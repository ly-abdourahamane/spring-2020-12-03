package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;
import fr.formation.service.MusiqueService;

//@Component
public class Application {
//	@Autowired
//	private IMusicien guitariste;
	
	@Autowired
	private MusiqueService srvMusique;
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext ctx =
//			new ClassPathXmlApplicationContext("classpath:/application-context.xml");
		
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppConfig.class);
		
		ctx.getBean(Application.class).run();
//		ctx.getBeanFactory().createBean(Application.class).run();
		
		IMusicien guitariste = ctx.getBean("LeGuitariste", IMusicien.class);
//		guitariste.jouer();
		
//		IMusicien guitariste2 = ctx.getBean("guitariste", IMusicien.class);
		
		ctx.close();
	}
	
	public void run() {
		System.out.println("Thread = " + Thread.currentThread().getName());
		this.srvMusique.jouer();
	}
}