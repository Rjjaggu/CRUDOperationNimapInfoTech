package com.bikkadit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bikkadit.entity.User;

@SpringBootApplication
public class CurdOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOperationApplication.class, args);
		
        System.out.println("CURD Operation Running..");	
	}

}
