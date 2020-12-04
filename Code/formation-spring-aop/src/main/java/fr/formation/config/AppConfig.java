package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("fr.formation")
@PropertySource("classpath:/musique.properties")
@EnableAspectJAutoProxy
public class AppConfig {
	
}