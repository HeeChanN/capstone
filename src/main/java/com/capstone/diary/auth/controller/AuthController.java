package com.capstone.diary.auth.controller;


import com.capstone.diary.auth.service.AuthService;
import com.capstone.diary.auth.dto.LoginDto;
import com.capstone.diary.auth.dto.LoginResDto;
import com.capstone.diary.auth.dto.MemberCreateDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name="Auth API", description = "로그인, 회원가입, 토큰 재발급 관련 API")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody MemberCreateDto memberCreateDto) {
        return authService.createMember(memberCreateDto);
    }

    @PostMapping("/login")
    public LoginResDto login(@RequestBody LoginDto loginDto) {
        log.info("로그인 시작");
        return authService.login(loginDto);
    }
}
