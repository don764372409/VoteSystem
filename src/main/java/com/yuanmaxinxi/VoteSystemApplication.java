package com.yuanmaxinxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class VoteSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteSystemApplication.class, args);
	}
}
