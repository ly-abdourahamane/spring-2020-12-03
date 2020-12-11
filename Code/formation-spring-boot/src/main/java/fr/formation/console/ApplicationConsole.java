package fr.formation.console;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ApplicationConsole implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application SPRING Console !");
	}
}