package com.capstone.diary.ai.swagger;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@SecurityRequirement(name = "bearerAuth")
@Operation(summary = "일기 조회", description = "날짜, petId를 통해 일기를 조회한다. 만약 petId 정보가 없거나, 일기가 아직 생성되지 " +
        "않았을 경우 400 에러가 return 된다.")
public @interface AIMessageGetApi {
}
