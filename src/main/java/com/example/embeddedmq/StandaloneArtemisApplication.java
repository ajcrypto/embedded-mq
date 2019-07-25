package com.example.embeddedmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class StandaloneArtemisApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandaloneArtemisApplication.class, args);
	}


}

