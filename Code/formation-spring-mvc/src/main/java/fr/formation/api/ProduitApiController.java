package fr.formation.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.exception.DemoStatusException;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

//@Controller
//@ResponseBody //à ajouter si utilisation de @Controller vs @RestController
@RestController
public class ProduitApiController {
	@Autowired
	private ProduitService srvProduit;
	
	@GetMapping("/api/produit/demo")
	public String demo() {
		return "demo...";
	}
	
	//produit.json
	//produit.xml
	//ou changer l'en-tête HTTP "Accept" => Headers: application/json | application/xml
	@GetMapping(value = "/api/produit/demo/produit", produces = { "application/json", "application/xml" })
	public Produit produit() {		
		return this.srvProduit.findAll().get(0);
	}
	
	@GetMapping("/api/produit/demo/status")
	@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Pas le droit...")
	public String status() {
		return "demo";
	}
	
	@GetMapping("/api/produit/demo/status/{ok}")
	public String status(@PathVariable boolean ok) {
		if (!ok) {
			throw new DemoStatusException();
		}
		
		return "demo";			
	}
	
	@PostMapping("/api/produit/ajouter")
	public String add(@Valid @RequestBody Produit produit, BindingResult result) {
		if (result.hasErrors()) {
			throw new DemoStatusException();
		}
		
		return "demo";			
	}
}