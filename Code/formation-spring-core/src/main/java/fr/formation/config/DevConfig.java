package fr.formation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("dev")
//@Profile("!dev")
// -Dspring.profiles.active=dev dans les arguments de Application
@PropertySource("classpath:/musique-dev.properties")
public class DevConfig {
	public DevConfig() {
		System.out.println("CREATION DEV CONFIG");
	}
}