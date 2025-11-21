package br.com.portability.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Portability API")
                        .version("1.0")
                        .description("API for managing portabilities")
                        .contact(new Contact()
                                .name("Your Name")
                                .url("http://yourwebsite.com")
                                .email("paula.leticia.braz@gmail.com")));
    }
}
