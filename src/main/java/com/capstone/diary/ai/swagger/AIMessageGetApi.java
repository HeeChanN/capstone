package com.capstone.diary.ai.swagger;


import com.capstone.diary.ai.dto.AIMessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
@Operation(summary = "AI 분석 메시지 조회", description = "요청 보낸 시점에서 이전 메시지 전부 + 이후 메시지 도착한것들 전송")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = AIMessageDto.class)))),
        @ApiResponse(responseCode = "400", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "유저 정보가 존재하지 않을 경우", value = "유저 정보를 찾을 수 없습니다."),
                        })),
        @ApiResponse(responseCode = "401", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "인증정보 불일치", value = "올바른 접근이 아닙니다.")
                        }))

})
public @interface AIMessageGetApi {
}
