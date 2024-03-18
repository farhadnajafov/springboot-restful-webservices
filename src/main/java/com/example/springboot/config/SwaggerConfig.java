package com.example.springboot.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        Contact contact = new Contact();
        contact.setEmail("farhadnajafov98@gmail.com");
        contact.setName("Farhad");
        contact.setUrl("https://www.farhadnajafov.com");

        Info info = new Info()
                .title("Spring Boot REST API Documentation")
                .description("Spring Boot REST API Documentation")
                .version("v1.0")
                .contact(contact)
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.farhadnajafov.com/license"));

        ExternalDocumentation externalDocumentation = new ExternalDocumentation()
                .description("Spring Boot User Management Documentation")
                .url("https://www.farhadnajafov.com/user_management.html");

        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }

}
