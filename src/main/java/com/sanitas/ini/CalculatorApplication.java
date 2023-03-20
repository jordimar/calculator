package com.sanitas.ini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.corp.calculator.TracerImpl;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	  @Bean
	  public TracerImpl getTracerApiInstance() {
	    return new TracerImpl();
	  }
}
