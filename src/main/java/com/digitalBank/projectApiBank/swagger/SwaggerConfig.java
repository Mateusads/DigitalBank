package com.digitalBank.projectApiBank.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.digitalBank.projectApiBank.entities.Client;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
    	return new Docket(DocumentationType.SWAGGER_2)
    		    .select()
    		    .apis(RequestHandlerSelectors.any())
    		    .paths(PathSelectors.any())
    		    .paths(Predicates.not(PathSelectors.regex("/error.*")))
    		    .build();
    }
    
    Client client = new Client();
    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder()
                .code(400)
                .message("Data error")
                .responseModel(new ModelRef("Error"))
                .build());
            add(new ResponseMessageBuilder()
                .code(403)
                .message("Forbidden!")
                .build());
        }};
    }
    
    
}