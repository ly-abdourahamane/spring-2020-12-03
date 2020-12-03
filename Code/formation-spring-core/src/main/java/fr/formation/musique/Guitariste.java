package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype") //prototype | singleton (par défaut)
//session | request ==> contexte web (tomcat / spring boot + starter-web)
public class Guitariste implements IMusicien {
	@Autowired
	private IInstrument instrument;
	
	public Guitariste() {
		System.out.println("CONSTRUCTEUR GUITARISTE");
	}
	
	@Autowired
	public Guitariste(IInstrument instrument) {
		System.out.println("CONSTRUCTEUR GUITARISTE");
		this.instrument = instrument;
		System.out.println(this.instrument);
	}
	
//	@PostConstruct
//	public void init() {
//		System.out.println(this.instrument);
//	}

	@Async
	public void jouer() { // Démarrage de Async
//		System.out.println("Guitariste joue : " + this.instrument);
		System.out.println("Thread = " + Thread.currentThread().getName());
		this.jouerAsync();
		//Guitariste -> jouerAsync()
	} //Fin de Async

	@Async
	public void jouerAsync() { //Utilise le Async déjà créé
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thread = " + Thread.currentThread().getName());
		System.out.println("Guitariste joue : " + this.instrument);
	} //Rien de spécial
}