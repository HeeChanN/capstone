package com.capstone.diary.member.controller;



import com.capstone.diary.auth.dto.MemberCreateDto;
import com.capstone.diary.member.dto.MemberInfoDto;
import com.capstone.diary.member.service.MemberService;
import com.capstone.diary.member.swagger.MemberGetApi;
import com.capstone.diary.member.swagger.MemberUpdateApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
@Tag(name = "Member API",description = "회원 정보 관련 API")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    @MemberGetApi
    public MemberInfoDto getMemberInfo(@PathVariable("memberId") Long memberId){
        return memberService.getMemberInfo(memberId);
    }

    @PatchMapping("/{memberId}")
    @MemberUpdateApi
    public MemberInfoDto updateMemberInfo(@PathVariable("memberId") Long memberId, @RequestBody MemberCreateDto memberCreateDto){
        return memberService.updateMemberInfo(memberId, memberCreateDto);
    }


}
