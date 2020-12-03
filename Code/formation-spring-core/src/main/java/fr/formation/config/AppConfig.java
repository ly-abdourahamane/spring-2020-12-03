package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.formation.Application;

@Configuration
@ComponentScan("fr.formation")
public class AppConfig {
	@Bean
	public Application app() {
		return new Application();
	}
}