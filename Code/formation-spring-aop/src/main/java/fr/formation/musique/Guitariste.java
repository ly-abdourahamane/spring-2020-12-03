package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("LeGuitariste")
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

//	@Log
	public void jouer() {
		System.out.println("Guitariste joue : " + this.instrument);
	}

	public String jouer(String morceau) {
		System.out.println("Guitariste joue le morceau : " + morceau);
		return this.instrument.toString();
	}
}