package com.consumerbanking.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBankingApplication.class, args);
	}

}
