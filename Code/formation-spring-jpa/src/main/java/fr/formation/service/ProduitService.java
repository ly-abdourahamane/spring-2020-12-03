package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ProduitRepository;
import fr.formation.model.Produit;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository daoProduit;

	public List<Produit> findAll() {
		return this.daoProduit.findAll();
	}
	
	public void add(Produit produit) {
		this.daoProduit.add(produit);
	}
}