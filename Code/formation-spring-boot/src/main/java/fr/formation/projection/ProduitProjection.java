package fr.formation.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProduitProjection {
	public int getId();
	public String getLabel();
	
	@Value("#{target.utilisateur.username}")
	public String getUsername();
}