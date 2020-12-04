package fr.formation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Produit;

@Repository
public class ProduitRepository {
	@PersistenceContext
	private EntityManager em;
	
	public List<Produit> findAll() {
		return this.em
				.createQuery("select p from Produit p", Produit.class)
				.getResultList();
	}
	
	@Transactional
	public Produit add(Produit produit) {
//		this.em.getTransaction().begin();
		this.em.persist(produit);
//		this.em.getTransaction().commit();
		return produit;
	}
	
	public Produit save(Produit produit) {
		return this.em.merge(produit);
	}
}