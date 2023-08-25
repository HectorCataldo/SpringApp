package com.kps.SpringApp;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringAppApplication.class, args);

		ClientRepository cp = context.getBean(ClientRepository.class);

		//Fechas
		LocalDate fecha =  LocalDate.of(2003,8,25);
		LocalDate Fecha2 = LocalDate.of(2001, 5, 23);
		LocalDate fecha3= LocalDate.of(1996, 12, 2);
		/*//Formateo
		String patron = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patron);

		//Agregando Formato
		String fechaF1 = fecha.format(formatter);
		LocalDate parsed1 = LocalDate.parse(fechaF1, formatter);
		//
		String fechaF2 = Fecha2.format(formatter);
		LocalDate parsed2 = LocalDate.parse(fechaF2, formatter);
		//
		String fechaF3 = fecha3.format(formatter);
		LocalDate parsed3 = LocalDate.parse(fechaF3, formatter);*/

		Client c3 = new Client(null,"20.123.145-2","Marisabel", "Rodriguez", fecha);
		Client c1 = new Client(null,"20.581.217-2","Hector", "Cataldo", Fecha2);
		Client c2 = new Client(null,"16.789.345-2","Federico", "Herrera", fecha3);

		cp.save(c1);
		cp.save(c2);
		cp.save(c3);


	}

}
