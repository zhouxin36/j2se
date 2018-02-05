package com.j2se.transactionannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.j2se.transactionannotation.dao")
public class TransactionannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionannotationApplication.class, args);
	}
}
