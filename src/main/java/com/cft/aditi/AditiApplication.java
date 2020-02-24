package com.cft.aditi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = { "com.cft" })
@ComponentScan("com.cft")
@EnableJpaRepositories("com.cft")
public class AditiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AditiApplication.class, args);
	}

}
