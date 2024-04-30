package com.capstone.diary.member.controller;



import com.capstone.diary.member.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "Member API",description = "회원 정보 관련 API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping()
    public void getMemberInfo(){
        memberService.getMemberInfo();
    }
}
