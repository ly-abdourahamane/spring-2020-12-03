package fr.formation.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.ProduitRepository;
import fr.formation.model.Produit;
import fr.formation.projection.ProduitProjection;
import fr.formation.projection.Views;

@RestController
@RequestMapping("/api/produit")
public class ProduitApiController {
	private final Logger logger = LoggerFactory.getLogger(ProduitApiController.class);
	
	@Autowired
	private ProduitRepository daoProduit;
	
	@GetMapping
	@JsonView(Views.Produit.class)
	@Cacheable(value = "produitsFindAll")
	public List<Produit> findAll() {
		this.logger.debug("findAll produit called");
		return this.daoProduit.findAll();
	}
	
	@GetMapping("/details")
	@JsonView(Views.ProduitDetailled.class)
	public List<Produit> findAllDetailled() {
		return this.daoProduit.findAll();
	}
	
	@GetMapping("/projection")
	public List<ProduitProjection> findAllProjected() {
		return this.daoProduit.findAllProjected();
	}
	
	@GetMapping("/add")
	@CacheEvict(value = { "produitsFindAll" }, allEntries = true)
	public ProduitProjection add() {
		return null;
	}
}