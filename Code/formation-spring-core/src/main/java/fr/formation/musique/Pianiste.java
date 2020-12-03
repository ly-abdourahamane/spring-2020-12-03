package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //C'est cette référence à utiliser en priorité
public class Pianiste implements IMusicien {
	@Autowired
	private IInstrument instrument;
	
	public Pianiste() {
		System.out.println("CONSTRUCTEUR GUITARISTE");
	}

	public void jouer() {
		System.out.println("Pianiste joue : " + this.instrument);
	}
}