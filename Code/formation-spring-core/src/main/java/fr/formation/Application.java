package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

public class Application {
	@Autowired
	private IMusicien guitariste;
	
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ctx =
//			new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
//		AnnotationConfigApplicationContext ctx =
//			new AnnotationConfigApplicationContext(AppConfig.class);
//		
//		IMusicien guitariste = ctx.getBean("guitariste", IMusicien.class);
//		guitariste.jouer();
	}
	
	
	public void run() {
		this.guitariste.jouer();
	}
}