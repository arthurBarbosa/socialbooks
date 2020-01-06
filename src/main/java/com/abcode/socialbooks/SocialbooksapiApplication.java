package com.abcode.socialbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SocialbooksapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialbooksapiApplication.class, args);
	}

}
