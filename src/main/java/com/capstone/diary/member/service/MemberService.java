package com.capstone.diary.member.service;

import com.capstone.diary.auth.dto.MemberCreateDto;
import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.member.dto.MemberInfoDto;

public interface MemberService {
    public MemberInfoDto getMemberInfo(Long memberId) throws NoDataInDatabaseException;
    public MemberInfoDto updateMemberInfo(Long memberId, MemberCreateDto memberCreateDto) throws NoDataInDatabaseException;
}
