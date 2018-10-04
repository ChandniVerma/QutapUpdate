package com.exilant.QutapApplication;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages="com.exilant")
@EnableWebMvc
public class QutapApplication {

	public static void main(String[] args) {
		SpringApplication.run(QutapApplication.class, args);
	}
	
	@Bean
	public Docket api(){
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
	

	@Bean 
    public ValidatingMongoEventListener validatingMongoEventListener() { 
		System.out.println("validatingMongoEventListener() ---called");
        return new ValidatingMongoEventListener(validator()); 
    } 
 
    @Bean 
    public LocalValidatorFactoryBean validator() { 
    	System.out.println("validator() ---called");
        return new LocalValidatorFactoryBean(); 
    } 
}
