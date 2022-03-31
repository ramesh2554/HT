package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class BookConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("spring.swagger").apiInfo(apiInfo()).select()
				.paths(regex("/bookService. *")).build();

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Book Service").description("this is a demo book wriiten by me")
				.termsOfServiceUrl("https://github.com/IIHT-Spring").license("this book is licensed to nishant")
				.licenseUrl("https://github.com/IIHT-Spring").version("1.0").build();

	}

}