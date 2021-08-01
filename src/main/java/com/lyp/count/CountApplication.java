package com.lyp.count;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountApplication.class, args);
	}

}
