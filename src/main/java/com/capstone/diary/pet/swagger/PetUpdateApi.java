package com.capstone.diary.pet.swagger;


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
@Operation(summary = "반려동물 수정", description = "반려 동물 수정 API")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "반려동물 수정 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = PetResDto.class))),
        @ApiResponse(responseCode = "400", description = "요청 처리 실패",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {
                                @ExampleObject(name = "반려동물 정보가 존재하지 않을 경우", value = "반려동물를 찾을 수 없습니다.")
                        }))

})
public @interface PetUpdateApi {
}
