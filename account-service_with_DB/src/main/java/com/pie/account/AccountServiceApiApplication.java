package com.pie.account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApiApplication.class, args);
		System.out.println("Welcome to spring boot rest api project");
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



}
