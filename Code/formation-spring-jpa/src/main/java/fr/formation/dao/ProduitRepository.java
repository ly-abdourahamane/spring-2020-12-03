package fr.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.formation.model.Produit;

public class ProduitRepository {
	@PersistenceContext
	private EntityManager em;
	
	public List<Produit> findAll() {
		return this.em
				.createQuery("select p from Produit p", Produit.class)
				.getResultList();
	}
	
	public Produit add(Produit produit) {
		this.em.persist(produit);
		
		return produit;
	}
	
	public Produit save(Produit produit) {
		return this.em.merge(produit);
	}
}