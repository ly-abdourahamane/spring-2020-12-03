package fr.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //ACTIVE LES METHODES @Async
@EnableCaching //ACTIVE LE CACHE
public class FormationSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(FormationSpringBootApplication.class, args);
	}
}