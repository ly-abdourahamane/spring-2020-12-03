package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import fr.formation.Application;
import fr.formation.musique.IMusicien;

@Configuration
@ComponentScan("fr.formation")
@PropertySource("classpath:/musique.properties")
//@PropertySource("classpath:/musique-${spring.profiles.active}.properties")
@EnableAsync //ACTIVE l'ASYNCHRONE
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean("nomDeApp") //Changer le nom ici
	@Primary
	public Application app() { //Par défaut, le nom du bean, c'est le nom de la méthode
		String son =
			this.env.getProperty("instrument.guitare.son", String.class, "BIM BIM BIM");
		return new Application();
	}
	
	@Bean
//	public Application app2(@Qualifier("pianiste") IMusicien musicien) {
	public Application app2(IMusicien pianiste) { //On injecte le musicien pianiste
		return new Application();
	}
	
	@Bean
//	public Application app2(@Qualifier("pianiste") IMusicien musicien) {
	public Application app3(IMusicien pianiste, IMusicien LeGuitariste) {
		if (true) {
			//utiliser pianiste
		}
		
		else {
			//utiliser guitariste
		}
		
		return new Application();
	}
}