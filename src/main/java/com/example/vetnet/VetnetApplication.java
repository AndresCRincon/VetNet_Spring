package com.example.vetnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class VetnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetnetApplication.class, args);
	}

}
