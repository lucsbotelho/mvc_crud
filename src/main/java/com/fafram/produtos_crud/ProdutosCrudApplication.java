package com.fafram.produtos_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fafram.produtos_crud")
public class ProdutosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosCrudApplication.class, args);
	}

}
