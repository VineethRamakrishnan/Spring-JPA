package com.vikas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IntermediateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntermediateApplication.class, args);
	}
	
	@Bean
	  public Docket api() { 
	      return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())  
	        .select()                                  
	        .apis(RequestHandlerSelectors.basePackage("com.vikas"))
	        .paths(PathSelectors.any())                          
	        .build();                                           
	  }
	  
	  /**
	   *Adding basic info in swagger documentation.
	   * 
	   */
	  private ApiInfo apiInfo() {
		 return new ApiInfoBuilder().title("STUDENT API")
			.description("STUDENT API reference for developers")
			.license("STUDENT API License")
			.licenseUrl("vikas.sivaravindran@accenture.com").build();
	  }
	  
	  
}
