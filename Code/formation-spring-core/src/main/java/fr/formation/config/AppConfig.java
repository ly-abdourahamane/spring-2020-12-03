package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import fr.formation.Application;

@Configuration
@ComponentScan("fr.formation")
@PropertySource("classpath:/musique.properties")
//@PropertySource("classpath:/musique-${spring.profiles.active}.properties")
@EnableAsync //ACTIVE l'ASYNCHRONE
public class AppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public Application app() {
		String son =
			this.env.getProperty("instrument.guitare.son", String.class, "BIM BIM BIM");
		return new Application();
	}
}