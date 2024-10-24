package com.example.apischeduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ApischedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApischedulerApplication.class, args);
	}

}
