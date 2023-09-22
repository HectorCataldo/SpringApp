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
				true);
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
				true);
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
				true);

		cp.save(c1);
		cp.save(c2);
		cp.save(c3);
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
