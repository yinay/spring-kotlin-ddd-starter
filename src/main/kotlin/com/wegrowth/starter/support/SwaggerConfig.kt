package com.wegrowth.starter.support

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun apiAdminGroup(): GroupedOpenApi =
        GroupedOpenApi
            .builder()
            .group("com.wegrowth")
            .pathsToMatch("/**")
            .build()


    @Bean
    fun apiInfo(): OpenAPI {
        val securitySchemeName = "bearerAuth"
        return OpenAPI()
            .addSecurityItem(SecurityRequirement().addList(securitySchemeName))
            .components(
                Components().addSecuritySchemes(
                    securitySchemeName,
                    SecurityScheme().name(securitySchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                )
            )
            .info(
                Info()
                    .title("Rest Api")
                    .description("Rest Api for starter")
                    .version("1.0")
            )
    }


}