package net.testing.backendTests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestsApplication.class, args);
		System.out.print("Funcionando");
	} 

}
