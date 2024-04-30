package com.capstone.diary.member.service;


import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.member.dto.MemberInfoDto;
import com.capstone.diary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberInfoDto getMemberInfo() throws NoDataInDatabaseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new MemberInfoDto(memberRepository.findByLoginId(authentication.getName()).orElseThrow(()-> new NoDataInDatabaseException("해당 유저 정보가 존재하지 않습니다.")));
    }
}
