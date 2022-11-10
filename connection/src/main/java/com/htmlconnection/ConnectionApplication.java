package com.htmlconnection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.htmlconnection")
public class ConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionApplication.class, args);
	}

}
