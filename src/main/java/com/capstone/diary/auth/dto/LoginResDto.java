package com.capstone.diary.auth.dto;


import com.capstone.diary.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResDto {
    private String access_token;
    private String loginId;
    private String email;
    private String phoneNumber;
    private String name;

    public LoginResDto(String access_token, Member member) {
        this.access_token = access_token;
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.phoneNumber = member.getPhoneNumber();
        this.name = member.getName();
    }
}
