package com.capstone.diary.member;


import com.capstone.diary.auth.dto.MemberCreateDto;
import com.capstone.diary.image.Image;
import com.capstone.diary.pet.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Pet> pets = new ArrayList<>();

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

    public void updateMember(MemberCreateDto memberCreateDto) {
        this.loginId = memberCreateDto.getLoginId();
        this.email = memberCreateDto.getEmail();
        this.phoneNumber = memberCreateDto.getPhoneNumber();
        this.name = memberCreateDto.getName();
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
