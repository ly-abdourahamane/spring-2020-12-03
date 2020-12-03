package fr.formation.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import fr.formation.musique.IMusicien;

@Service
public class MusiqueService {
//	@Autowired
	@Qualifier("pianiste")
//	@Resource("${musicien}") //On passe par la resource parce que le contenu de @Qualifier ne peut pas être SpEL
	private IMusicien guitariste;
	

	//On peut utiliser le nom de l'attribut pour récupérer un bean nommé de la même façon
	//Ou bien utiliser @Qualifier("nomDuBean")
//	private IMusicien pianiste;
	
	@Async
	public void jouer() {
		try {
			Thread.sleep(1000);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread service = " + Thread.currentThread().getName());
		this.guitariste.jouer();
	}
}