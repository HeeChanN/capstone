package com.capstone.diary.member.dto;


import com.capstone.diary.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberInfoDto {

    private Long id;
    private String loginId;
    private String email;
    private String phoneNumber;
    private String name;

    public MemberInfoDto(Member member) {
        this.id = member.getId();
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.phoneNumber = member.getPhoneNumber();
        this.name = member.getName();
    }
}
