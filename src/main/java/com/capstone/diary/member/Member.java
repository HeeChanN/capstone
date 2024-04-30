package com.capstone.diary.member;


import com.capstone.diary.auth.dto.MemberCreateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String password;
    private String email;
    private String phoneNumber;
    private String name;

    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Authority> authorities;

    public void setAuthorities(List<Authority> roles) {
        this.authorities = roles;
        roles.forEach(o -> o.setMember(this));
    }

    public Member(MemberCreateDto memberCreateDto, String password) {
        this.loginId = memberCreateDto.getLoginId();
        this.password = password;
        this.email = memberCreateDto.getEmail();
        this.phoneNumber = memberCreateDto.getPhoneNumber();
        this.name = memberCreateDto.getName();
    }

}
