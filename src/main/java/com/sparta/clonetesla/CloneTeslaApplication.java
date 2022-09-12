package com.sparta.clonetesla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloneTeslaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneTeslaApplication.class, args);
	}

}
