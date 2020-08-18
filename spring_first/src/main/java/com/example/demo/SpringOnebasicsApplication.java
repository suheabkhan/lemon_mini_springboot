package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.demo.model")
public class SpringOnebasicsApplication {

	public static void main(String[] args) {
		//System.setProperty("server.port",
				//"9000");
		SpringApplication.run(SpringOnebasicsApplication.class, args);
	}

}
