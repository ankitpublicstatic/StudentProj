package org.ankit;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class Proj2RestAnkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj2RestAnkitApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration() {
		//Return a Prepared Docket objet
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("org.ankit"))
				.build()
				.apiInfo(apiMetaData());
	}
	private ApiInfo apiMetaData() {
		return new ApiInfo(
				"Address book API",
				"Sample Api for Ankit Teaches tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ankit Kumar", "http://ankitteaches.com", "ankitteaches@gmail.com"),
				"Api License",
				"https://ankitteaches.com",
				Collections.emptyList()
				);
	}
}
