package net.javaguides.department_service;

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
				title = "Department Service Rest API",
				description = "Department Service Rest API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "shakil",
						email = "shakil91021@gmail.com",
						url = "https://luxury-nougat-e70ab9.netlify.app/"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://luxury-nougat-e70ab9.netlify.app/"

				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Department Service Doc",
				url = "https://luxury-nougat-e70ab9.netlify.app/"
		)
)
@SpringBootApplication

public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
