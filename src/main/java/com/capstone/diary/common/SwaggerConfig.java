package com.capstone.diary.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Capstone 프로젝트",description = "펫다이어리 서비스 API 명세서",version = "v1")
)
public class SwaggerConfig {


}
