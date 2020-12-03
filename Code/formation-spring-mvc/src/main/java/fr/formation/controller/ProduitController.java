package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService srvProduit;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("produits", this.srvProduit.findAll());
		
		return "produit/liste";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		return "produit/form";
	}
	
	@PostMapping("/ajouter")
	public String add(Produit produit) {
		this.srvProduit.add(produit);
		
//		return "redirect:../";
		return "redirect:/produit";
	}
}