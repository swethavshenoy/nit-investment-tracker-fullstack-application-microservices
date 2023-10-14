package com.natwest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WatchlistserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(WatchlistserviceApplication.class, args);
	}
}
