package com.kps.SpringApp;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringAppApplication.class, args);

		ClientRepository cp = context.getBean(ClientRepository.class);

		Client c1 = new Client(null,"20.581.217-2","Hector", "Cataldo", LocalDate.of(2001, 5, 23));
		Client c2 = new Client(null,"16.789.345-2","Federico", "Herrera", LocalDate.of(1996, 12, 2));

		cp.save(c1);
		cp.save(c2);

	}

}
