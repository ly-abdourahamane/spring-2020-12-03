package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {
	public Guitare() {
		System.out.println("CONSTRUCTION GUITARE");
	}
}