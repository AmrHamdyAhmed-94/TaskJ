package com.jpay;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {                                    
    @Bean
    public Docket api() { 
    	
        Contact contact = new Contact(
                "Jpay Task",
                "", 
                "amrhamdyahmed94@gmail.com"
        );
        
        @SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
        
        ApiInfo apiInfo = new ApiInfo(
       "Jpay Task Documentation", 
       "this is the endpoints documentation", "1.0",
       "", contact, "", "",vendorExtensions);
        
        
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(apiInfo)
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.jpay"))              
          .paths(PathSelectors.any())                          
          .build();   
        
    }
    
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
