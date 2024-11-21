package com.apirestHibernate.apiRestHJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.apirestHibernate.apiRestHJPA", "com/apirestHibernate/apiRestHJPA/Controllers", "com/apirestHibernate/apiRestHJPA/Service", "com/apirestHibernate/apiRestHJPA/DAO"})
public class ApiRestHjpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiRestHjpaApplication.class, args);
	}
}
