package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.formation.dao.ProduitRepository;
import fr.formation.model.Produit;
import fr.formation.projection.ProduitProjection;

@Service
public class ProduitService {
	@Autowired
	private ProduitRepository daoProduit;

	public List<Produit> findAll(Pageable page) {
		this.daoProduit.findAll(Produit.class);
		this.daoProduit.findAll(ProduitProjection.class);
		
		Sort sortBy = Sort.by("label", "price");
		Pageable pageable = PageRequest.of(0, 10);
		
		return this.daoProduit.findAll(pageable).getContent();
	}

	public List<Produit> findAllSpec() {
		Specification<Produit> spec = (root, query, builder) -> {
			return builder.like(root.get("label"), "%a%");
		};
		
//		spec = spec.and(other) ...
		
		return this.daoProduit.findAll(spec);
	}
	
	public void add(Produit produit) {
		this.daoProduit.save(produit);
	}
}