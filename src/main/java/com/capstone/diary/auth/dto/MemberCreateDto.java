package com.capstone.diary.auth.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateDto {

    private String loginId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
}
