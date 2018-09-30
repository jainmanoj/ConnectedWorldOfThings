package com.worldofthings;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.web.util.AntPathRequestMatcher;

//@Configuration
//@EnableAutoConfiguration
@SpringBootApplication
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
@ComponentScan({"com.worldofthings","org.spring.io.example.reactive"})
public class MainWorldOfThings {
	public static void main(String[] args) {
		SpringApplication.run(MainWorldOfThings.class, args);
	}

}




