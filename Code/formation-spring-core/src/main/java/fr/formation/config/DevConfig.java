package fr.formation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
//@Profile("!dev")
// -Dspring.profiles.active=dev dans les arguments de Application
public class DevConfig {
	public DevConfig() {
		System.out.println("CREATION DEV CONFIG");
	}
}