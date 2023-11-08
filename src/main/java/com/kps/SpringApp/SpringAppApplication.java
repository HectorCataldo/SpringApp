package com.kps.SpringApp;

import com.kps.SpringApp.entities.Client;
import com.kps.SpringApp.entities.Profession;
import com.kps.SpringApp.repositories.ClientRepository;
import com.kps.SpringApp.repositories.ProfessionRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringAppApplication.class, args);

		ClientRepository cp = context.getBean(ClientRepository.class);
		ProfessionRepository pr = context.getBean(ProfessionRepository.class);
		//ctrl + d (copiar linea)
		//ctrl + / (comentar)

		Profession profession1 = new Profession(null,"Médico");
		Profession profession2 = new Profession(null,"Ingeniero");
		Profession profession3 = new Profession(null,"Albañil");
		Profession profession4 = new Profession(null,"Policia");
		Profession profession5 = new Profession(null,"Abogado");
		Profession profession6 = new Profession(null,"Profesor");
		Profession profession7 = new Profession(null,"Artista");
		Profession profession8 = new Profession(null,"Psicólogo");
		Profession profession9 = new Profession(null,"Periodista");
		Profession profession10 = new Profession(null,"Arquitecto");
		Profession profession11 = new Profession(null,"Otro");

		String tpp1="Juridica";
		String tpp2="Natural";

		pr.save(profession1);
		pr.save(profession2);
		pr.save(profession3);
		pr.save(profession4);
		pr.save(profession5);
		pr.save(profession6);
		pr.save(profession7);
		pr.save(profession8);
		pr.save(profession9);
		pr.save(profession10);
		pr.save(profession11);

		//Fechas
		LocalDate fecha =  LocalDate.of(2003,8,25);
		LocalDate Fecha2 = LocalDate.of(2001, 5, 23);
		LocalDate fecha3= LocalDate.of(1996, 12, 2);
		LocalDate fecha4 = LocalDate.of(1995, 7, 15);
		LocalDate fecha5 = LocalDate.of(1990, 3, 10);
		LocalDate fecha6 = LocalDate.of(1988, 9, 5);
		LocalDate fecha7 = LocalDate.of(2000, 11, 20);
		LocalDate fecha8 = LocalDate.of(1992, 4, 30);
		LocalDate fecha9 = LocalDate.of(1997, 6, 8);
		LocalDate fecha10 = LocalDate.of(1985, 1, 12);
		LocalDate fecha11 = LocalDate.of(1993, 12, 7);
		LocalDate fecha12 = LocalDate.of(1998, 2, 28);
		LocalDate fecha13 = LocalDate.of(1987, 10, 19);
		LocalDate fecha14 = LocalDate.of(1994, 6, 18);
		LocalDate fecha15 = LocalDate.of(1989, 9, 27);
		LocalDate fecha16 = LocalDate.of(1986, 11, 8);
		LocalDate fecha17 = LocalDate.of(1991, 3, 14);
		LocalDate fecha18 = LocalDate.of(1983, 2, 5);
		LocalDate fecha19 = LocalDate.of(1999, 7, 30);
		LocalDate fecha20 = LocalDate.of(1997, 4, 22);

		LocalDate fc = LocalDate.of(2023,10,4);


		Client c3 = new Client(null,
				"20.123.145-2",
				"Maria Isabel",
				"Rodriguez",
				"Jara",
				fecha,
				"Femenino",
				"Chile",
				"956451203",
				"maria.isable@example.es",
				"El Monte 433",
				profession10,
				true,
				tpp2,
				fc);
		Client c1 = new Client(null,
				"20.581.217-2",
				"Hector",
				"Cataldo",
				"Seguel",
				Fecha2,
				"Masculino",
				"Chile",
				"56411424",
				"cataldo.hector@kopernicus.tech",
				"Pasaje Rodeo 1445",
				profession2,
				true,
				tpp2,
				fc);
		Client c2 = new Client(null,
				"16.789.345-2",
				"Federico",
				"Herrera",
				"Romero",
				fecha3,
				"Masculino",
				"Panama",
				"33564102",
				"fede@example.es",
				"Manuel Toledo 1306",
				profession3,
				true,
				tpp2,
				fc);

		Client c4 = new Client(null,
				"12.345.678-9",
				"Ana",
				"Gómez",
				"López",
				fecha4,
				"Femenino",
				"España",
				"987654321",
				"ana@example.com",
				"Calle Principal 789",
				profession1,
				true,
				tpp2,
				fc);

		Client c5 = new Client(null,
				"24.886.921-6",
				"Juan",
				"Sánchez",
				"Martínez",
				fecha5,
				"Masculino",
				"Mexico",
				"123456789",
				"juan@example.com",
				"Avenida Central 456",
				profession4,
				true,
				tpp2,
				fc);

		Client c6 = new Client(null,
				"18.658.443-0",
				"Laura",
				"Pérez",
				"García",
				fecha6,
				"Femenino",
				"Argentina",
				"567891234",
				"laura@example.com",
				"Boulevard Norte 123",
				profession6,
				true,
				tpp2,
				fc);

		Client c7 = new Client(null,
				"5.115.782-6",
				"Roberto",
				"López",
				"Díaz",
				fecha7,
				"Masculino",
				"Chile",
				"345678912",
				"roberto@example.com",
				"Calle Sur 789",
				profession5,
				true,
				tpp2,
				fc);

		Client c8 = new Client(null,
				"19.857.177-6",
				"Carolina",
				"Gutiérrez",
				"Torres",
				fecha8,
				"Femenino",
				"Colombia",
				"678912345",
				"carolina@example.com",
				"Avenida Este 456",
				profession7,
				true,
				tpp2,
				fc);

		Client c9 = new Client(null,
				"23.456.789-0",
				"Pedro",
				"Ramírez",
				"Hernández",
				fecha9,
				"Masculino",
				"Peru",
				"234567890",
				"pedro@example.com",
				"Calle Oeste 123",
				profession9,
				true,
				tpp2,
				fc);

		Client c10 = new Client(null,
				"12.868.510-3",
				"Sofía",
				"Vargas",
				"Silva",
				fecha10,
				"Femenino",
				"Uruguay",
				"789012345",
				"sofia@example.com",
				"Boulevard Sur 789",
				profession8,
				true,
				tpp2,
				fc);

		Client c11 = new Client(null,
				"9.050.882-2",
				"Javier",
				"Fernández",
				"Gómez",
				fecha11,
				"Masculino",
				"Ecuador",
				"123456789",
				"javier@example.com",
				"Avenida Norte 456",
				profession10,
				true,
				tpp2,
				fc);

		Client c12 = new Client(null,
				"23.270.949-9",
				"María",
				"López",
				"Hernández",
				fecha12,
				"Femenino",
				"Venezuela",
				"456789012",
				"maria@example.com",
				"Calle Este 123",
				profession3,
				true,
				tpp2,
				fc);

		Client c13 = new Client(null,
				"76.155.008-K",
				"Fernando",
				"García",
				"Ramírez",
				fecha13,
				"Masculino",
				"Brasil",
				"890123456",
				"fernando@example.com",
				"Boulevard Oeste 789",
				profession11,
				true,
				tpp1,
				fc);

		Client c14 = new Client(null,
				"82.113.740-3",
				"Luis",
				"Martínez",
				"García",
				fecha14,
				"Masculino",
				"España",
				"678901234",
				"luis@example.com",
				"Calle Mayor 789",
				profession1,
				true,
				tpp1,
				fc);

		Client c15 = new Client(null,
				"21.657.430-3",
				"Ana María",
				"Gómez",
				"Sánchez",
				fecha15,
				"Femenino",
				"México",
				"901234567",
				"anamaria@example.com",
				"Avenida Central 456",
				profession4,
				true,
				tpp2,
				fc);

		Client c16 = new Client(null,
				"73.171.229-8",
				"Raúl",
				"Hernández",
				"Díaz",
				fecha16,
				"Masculino",
				"Argentina",
				"345678901",
				"raul@example.com",
				"Boulevard Norte 123",
				profession6,
				true,
				tpp1,
				fc);

		Client c17 = new Client(null,
				"78.901.234-5",
				"Mónica",
				"López",
				"Torres",
				fecha17,
				"Femenino",
				"Chile",
				"789012345",
				"monica@example.com",
				"Calle Sur 789",
				profession5,
				true,
				tpp1,
				fc);

		Client c18 = new Client(null,
				"12.345.678-9",
				"Jorge",
				"Ramírez",
				"Silva",
				fecha18,
				"Masculino",
				"Colombia",
				"123456789",
				"jorge@example.com",
				"Avenida Este 123",
				profession7,
				true,
				tpp2,
				fc);

		Client c19 = new Client(null,
				"16.644.355-5",
				"Elena",
				"Gutiérrez",
				"Martínez",
				fecha19,
				"Femenino",
				"Peru",
				"456789012",
				"elena@example.com",
				"Calle Oeste 456",
				profession9,
				true,
				tpp2,
				fc);

		Client c20 = new Client(null,
				"11.974.691-4",
				"Carlos",
				"Fernández",
				"Gómez",
				fecha20,
				"Masculino",
				"Uruguay",
				"890123456",
				"carlos@example.com",
				"Boulevard Sur 789",
				profession8,
				true,
				tpp2,
				fc);

		// Guardar los nuevos clientes
		cp.save(c1);
		cp.save(c2);
		cp.save(c3);
		cp.save(c4);
		cp.save(c5);
		cp.save(c6);
		cp.save(c7);
		cp.save(c8);
//		cp.save(c9);
//		cp.save(c10);
//		cp.save(c11);
//		cp.save(c12);
//		cp.save(c13);
//		cp.save(c14);
//		cp.save(c15);
//		cp.save(c16);
//		cp.save(c17);
//		cp.save(c18);
//		cp.save(c19);
//		cp.save(c20);


	}
	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI().info(
				new Info()
						.title("SpringApp Client API REST")
						.version("0.1")
						.description("Spring boot API Rest from Client by KPS")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
