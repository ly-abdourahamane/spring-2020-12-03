package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

//@Component
public class Application {
	@Autowired
	private IMusicien guitariste;
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ctx =
//			new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBean(Application.class).run();
//		ctx.getBeanFactory().createBean(Application.class).run();
		
		IMusicien guitariste = ctx.getBean("guitariste", IMusicien.class);
//		guitariste.jouer();
		
		IMusicien guitariste2 = ctx.getBean("guitariste", IMusicien.class);
		
		ctx.close();
	}
	
	public void run() {
		this.guitariste.jouer();
	}
}