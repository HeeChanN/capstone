package com.capstone.diary.member.swagger;


import com.capstone.diary.member.dto.MemberInfoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@SecurityRequirement(name = "bearerAuth")
@Operation(summary = "내 정보 조회", description = "회원 인증 정보로 내 정보를 조회하는 API, JWT 토큰을 이용하여 내 정보를 조회합니다.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "내 정보 조회 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = MemberInfoDto.class))),
        @ApiResponse(responseCode = "400", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "유저 정보가 존재하지 않을 경우", value = "유저 정보를 찾을 수 없습니다."),
                                @ExampleObject(name = "인증정보 불일치", value = "올바른 접근이 아닙니다.")
                        }))

})
public @interface MemberGetApi {
}
