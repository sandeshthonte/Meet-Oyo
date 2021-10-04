package com.example.oyoUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EntityScan
@EnableJpaRepositories(basePackages = "com.example.oyoUser")
//@EnableTransactionManagement
@SpringBootApplication
public class OyoBackendApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(OyoBackendApplication.class, args);
		
	}	 
}
