package com.capstone.diary.home.swagger;


import com.capstone.diary.pet.dto.PetListDto;
import com.capstone.diary.pet.dto.PetResDto;
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
@Operation(summary = "반려동물 리스트 조회", description = "반려동물 리스트를 조회합니다.")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "반려동물 리스트 조회 성공", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = PetListDto.class))))
})
public @interface PetGetsApi {
}
