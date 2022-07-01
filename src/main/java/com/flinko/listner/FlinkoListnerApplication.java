package com.flinko.listner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.flinko.listner")
@EnableMongoRepositories
@EnableDiscoveryClient
@EnableFeignClients
public class FlinkoListnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlinkoListnerApplication.class, args);
	}

}
