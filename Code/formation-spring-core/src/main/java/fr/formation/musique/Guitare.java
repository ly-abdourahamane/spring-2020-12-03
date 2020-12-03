package fr.formation.musique;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Guitare implements IInstrument {
	@Value("${instrument.guitare.son:BIM BIM BIM}")
	private String son;
	
	public Guitare() {
		System.out.println("CONSTRUCTION GUITARE");
	}
	
	@Override
	public String toString() {
		return this.son;
	}
}