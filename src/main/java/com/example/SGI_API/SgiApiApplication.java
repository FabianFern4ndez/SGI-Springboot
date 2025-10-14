package com.example.SGI_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class SgiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgiApiApplication.class, args);
		//mvn spring-boot:
		
	}
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SGI API Documentation")
                        .version("1.0")
                        .description("Documentación de la API para el Sistema de Gestión de Items"));

}
}