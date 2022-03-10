package com.fabiobenoit.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.yawintutor.controller"})

public class SmallbusinessBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmallbusinessBackendApplication.class, args);
	}

}
