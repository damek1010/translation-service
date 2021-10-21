package com.ailleron.translation.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.net.URI;

@EnableOpenApi
@Configuration
@AllArgsConstructor
public class SwaggerConfig implements WebMvcConfigurer {

  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(
        new ApiInfoBuilder()
          .title("Translation Service - REST API documentation")
          .build()
      )
      .directModelSubstitute(URI.class, String.class)
      .useDefaultResponseMessages(false)
      .useDefaultResponseMessages(false)
      .select()
      .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
      .paths(PathSelectors.any())
      .build();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/swagger-ui/")
      .setViewName("redirect:/swagger-ui/index.html");
    registry.addViewController("/")
      .setViewName("redirect:/swagger-ui/index.html");
  }
}
