package com.example.spring_study.common.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Hiro Backend")
                        .description("Hiro Backend 서버")
                        .version("v0.0.1"));
    }
}
/*
@Configuration
public class SwaggerConfig {

  @Value("${server.servlet.context-path}")
  String contextPath;

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group("v1-definition")
        .pathsToMatch("/auth/**", "/customers/**", "/customer/**", "/course/**", "/law/**", "/quest/**")
        .build();
  }

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .addServersItem(new Server().url(contextPath + "/"))
        .info(new Info().title("iwp Backend")
            .description("iwp Backend 서버")
            .version("v0.0.1"));
  }
}

 */

/*
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        SecurityRequirement securityItem = new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .openapi("3.0.1")  // OpenAPI 버전 명시
                .components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
                .security(List.of(securityItem))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("PlayHive API")
                .description("PlayHive API Documentation")
                .version("1.0.0");
    }
}
 */