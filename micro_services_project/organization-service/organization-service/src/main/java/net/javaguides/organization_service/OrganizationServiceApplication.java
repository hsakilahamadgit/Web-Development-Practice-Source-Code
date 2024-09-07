package net.javaguides.organization_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization-Service Rest API",
				description = "Organization Service Rest API Documentation",
				version = "3.3.3",
				contact = @Contact(
						name = "Shakil Ahamad",
						email = "shakil91021@gmail.com",
						url = "https://luxury-nougat-e70ab9.netlify.app/"
				),
				license = @License(
						name = "apache 3.3.3",
						url = "https://luxury-nougat-e70ab9.netlify.app/"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service Doc",
				url = "https://luxury-nougat-e70ab9.netlify.app/"
		)
)

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
