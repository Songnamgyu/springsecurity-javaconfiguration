package com.poly.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



//Swageer란?
//서버로 요청되는 URL 리스트를 HTML화면으로 문서화 및 테스트 할 수 있는 라이브러리입니다.

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurationSupport {


	private static final String ApiName = "직원,학생정보 조회";
	private static final String ApiVersion = "0.0.1";
	private static final String ApiDescrption = "Rest API Server API 적용해보기";


	// Swagger 설정
	@Bean
	public Docket api() {
		
		String verson = "Test1";
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.groupName(verson);
	}
	
	@Bean
	public Docket api2() {
		
		String verson = "Test2";
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.poly.myapp"))
				.paths(PathSelectors.any())
				.build()
				.groupName(verson);
	}
	//Swagger Setting
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(ApiName)
				.version(ApiVersion)
				.description(ApiDescrption)
				.build();
	}
	
	

	/* Swagger UI 를 Resource Handler 에 등록 */ 
	
	
	

}
