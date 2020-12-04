package fr.formation.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public String add(@Valid Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			result.getFieldErrors().forEach(fe -> {
				if (fe.getField().equals("label")) {
					model.addAttribute("labelError", "Le label doit être saisi !");
				}
			});
			
			model.addAttribute("errors", result.getFieldErrors()
				.stream()
				.map(FieldError::getField)
				.distinct()
				.collect(Collectors.toList()));
			
			return "produit/form";
		}
		
		this.srvProduit.add(produit);
		
		return "redirect:/produit";
	}
}