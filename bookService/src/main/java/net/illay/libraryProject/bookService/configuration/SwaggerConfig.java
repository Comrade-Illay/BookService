package net.illay.libraryProject.bookService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Profile("dev")
@Configuration
public class SwaggerConfig {

    private static final String SWAGGER_PACKAGE = "net.illay.libraryProject.bookService.controller";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Book-service", "responsible for storing books and operate with them", "1.0", "",
                new Contact("iliabelov6@gmail.com", "No information", "No information"), "comrade.illay",
                "API license URL", Collections.emptyList());
    }
}
