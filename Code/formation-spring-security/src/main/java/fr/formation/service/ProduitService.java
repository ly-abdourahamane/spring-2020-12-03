package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
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

//	@PostFilter("hasPermission(returnObject, 'PRODUIT', 'READ')") //Si on veut filtrer la liste retournée, pour enlever des produits auxquels on aurait pas accès
	public List<Produit> findAllSpec(Authentication auth) {
		if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			return this.daoProduit.findAll();
		}
		
		Specification<Produit> spec = (root, query, builder) -> {
			return builder.like(root.get("label"), "%a%");
//			return builder.equal(root.get("public"), "true"); // Vérifier l'attribut public si pas admin (exemple non fonctionnel)
		};
		
//		spec = spec.and(other) ...
		
		return this.daoProduit.findAll(spec);
	}
	
//	@PreAuthorize("hasAuthority('PRODUIT_WRITE_...')")
	public void add(Produit produit) {
		this.daoProduit.save(produit);
	}
}