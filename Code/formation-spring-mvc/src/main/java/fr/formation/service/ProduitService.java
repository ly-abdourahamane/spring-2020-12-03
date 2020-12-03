package fr.formation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.model.Produit;

@Service
public class ProduitService {
	private List<Produit> produits = new ArrayList<>();
	
	public ProduitService() {
		this.add(new Produit("GoPRO HERO 8", new BigDecimal(499.99)));
	}

	public List<Produit> findAll() {
		return produits;
	}
	
	public void add(Produit produit) {
		this.produits.add(produit);
	}
}