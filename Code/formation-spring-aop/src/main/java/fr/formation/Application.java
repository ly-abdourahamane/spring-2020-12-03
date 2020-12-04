package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

public class Application {
	@Autowired
	private IMusicien guitariste;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBeanFactory().createBean(Application.class).run();
		
		ctx.close();
	}
	
	public void run() {
		this.guitariste.jouer();
	}
}