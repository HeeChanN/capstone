package com.capstone.diary.security;

import com.capstone.diary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return new CustomUserDetails(memberRepository.findByLoginId(loginId).orElseThrow(()-> new UsernameNotFoundException("해당 유저 정보다 존재하지 않습니다.")));
    }
}
