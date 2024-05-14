package com.capstone.diary.pet.swagger;


import com.capstone.diary.member.dto.MemberInfoDto;
import com.capstone.diary.pet.Pet;
import com.capstone.diary.pet.dto.PetResDto;
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
@Operation(summary = "반려동물 등록", description = "반려 동물 등록 API")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "반려동물 등록 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = PetResDto.class))),
        @ApiResponse(responseCode = "400", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "내 정보가 존재하지 않을 경우", value = "유저 정보를 찾을 수 없습니다.")
                        }))

})
public @interface PetCreateApi {
}
