package net.javaguides.employee_service;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service Rest Api",
				description = "Employee Service Documentation",
				version = "3.3.3",
				contact = @Contact(
						name = "Shakil Ahamad",
						email = "Shakil91021@gmail.com",
						url = "https://luxury-nougat-e70ab9.netlify.app/"
				),
				license =@License(
						name = "apache 3.3.3",
				url = "https://luxury-nougat-e70ab9.netlify.app/")
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee-Service Doc",
				url = "https://luxury-nougat-e70ab9.netlify.app/"
		)

)
@SpringBootApplication
@EnableFeignClients


public class EmployeeServiceApplication {

	// method 1 here we configure RestTemplate as spring been
	/*@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}*/
	//method 2 configuring web clint as spring bean
	@Bean
	public WebClient webClient(){
		return  WebClient.builder().build();

	}




	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
