package fr.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.musique.IMusicien;

public class Application {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
			new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		IMusicien guitariste = ctx.getBean("guitariste", IMusicien.class);
		guitariste.jouer();
	}
}