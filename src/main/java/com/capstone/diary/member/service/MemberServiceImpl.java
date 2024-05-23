package com.capstone.diary.member.service;


import com.capstone.diary.auth.dto.MemberCreateDto;
import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.member.Member;
import com.capstone.diary.member.dto.MemberInfoDto;
import com.capstone.diary.member.exception.NoMatchException;
import com.capstone.diary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberInfoDto getMemberInfo(Long memberId) throws NoDataInDatabaseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NoDataInDatabaseException("유저정보"));
        if (!member.getLoginId().equals(authentication.getName())) {
            throw new NoMatchException("올바른 접근이 아닙니다.");
        }
        return new MemberInfoDto(member);
    }

    @Transactional
    public MemberInfoDto updateMemberInfo(Long memberId, MemberCreateDto memberCreateDto) throws NoDataInDatabaseException {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NoDataInDatabaseException("유저정보"));
        if (!member.getLoginId().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            throw new NoMatchException("올바른 접근이 아닙니다.");
        }

        member.updateMember(memberCreateDto);
        if(memberCreateDto.getPassword() != null) {
            member.updatePassword(passwordEncoder.encode(memberCreateDto.getPassword()));
        }
        return new MemberInfoDto(member);
    }
}
