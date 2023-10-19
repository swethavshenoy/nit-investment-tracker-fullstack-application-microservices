package com.natwest.userauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserauthApplication.class, args);
	}

}
