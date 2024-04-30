package com.capstone.diary.auth.service;


import com.capstone.diary.auth.dto.LoginDto;
import com.capstone.diary.auth.dto.LoginResDto;
import com.capstone.diary.exception.common.DuplicatedDataException;
import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.exception.common.WrongDataException;
import com.capstone.diary.member.Authority;
import com.capstone.diary.member.Member;
import com.capstone.diary.auth.dto.MemberCreateDto;
import com.capstone.diary.member.repository.MemberRepository;
import com.capstone.diary.security.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public String createMember(MemberCreateDto memberCreateDto) throws DuplicatedDataException  {
        if(memberRepository.findByLoginId(memberCreateDto.getLoginId()).isPresent()){
            throw new DuplicatedDataException("이미 존재하는 ID 입니다.");
        }
        Member member = new Member(memberCreateDto, passwordEncoder.encode(memberCreateDto.getPassword()));
        member.setAuthorities(Collections.singletonList(Authority.builder().roleName("ROLE_USER").build()));
        memberRepository.save(member);
        return "회원 가입 완료";
    }

    public LoginResDto login(LoginDto loginDto) throws NoDataInDatabaseException, WrongDataException {
        Member member = memberRepository.findByLoginId(loginDto.getLoginId())
                .orElseThrow(() -> new NoDataInDatabaseException("잘못된 아이디 혹은 비밀번호"));
        if(!passwordEncoder.matches(loginDto.getPassword(), member.getPassword())) {
            throw new WrongDataException("비밀번호가 틀렸거나 아이디가 올바르지 않습니다."); // 401
        }
        return new LoginResDto(jwtProvider.createToken(member.getLoginId(),member.getAuthorities()),member);
    }
}
