package com.capstone.diary.ai.swagger;


import com.capstone.diary.ai.dto.AIMessageDto;
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
@Operation(summary = "AI 메시지 테스트용", description = "AI가 메시지를 분석해서 넣어주는 것 대신 미리 메시지를 넣어놓고 받아오는 것을 테스트할 수 있는 api")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "메시지 등록 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = AIMessageDto.class))),
        @ApiResponse(responseCode = "400", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "내 정보가 존재하지 않을 경우", value = "유저 정보를 찾을 수 없습니다.")
                        }))

})
public @interface AIMessageCreateApi {
}
