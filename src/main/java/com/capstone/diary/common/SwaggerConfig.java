package com.capstone.diary.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Capstone 프로젝트",description = "펫다이어리 서비스 API 명세서",version = "v1")
)
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }

//    @Bean
//    public OperationCustomizer customize() {
//        return (operation, handlerMethod) -> {
//            // 여기에서 조건을 지정합니다. 예를 들어, 특정 태그 또는 경로에 따라
//            if (operation.getOperationId().equals("getMember")) {
//                operation.addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
//            }
//            return operation;
//        };
//    }
}
