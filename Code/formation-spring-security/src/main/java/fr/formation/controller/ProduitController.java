package fr.formation.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	//produit?sort=label,desc&price,asc
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public String findAll(Authentication auth, Pageable page, Model model) {
//		model.addAttribute("produits", this.srvProduit.findAll(page));
		model.addAttribute("produits", this.srvProduit.findAllSpec(auth));
		
		return "produit/liste";
	}
	
	@GetMapping("/ajouter")
	@PreAuthorize("hasRole('ADMIN')")
	public String add() {
		return "produit/form";
	}
	
	@PostMapping("/ajouter")
	@PreAuthorize("hasRole('ADMIN')")
	public String add(@ModelAttribute("produit") @Valid Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getFieldErrors()
				.stream()
				.map(FieldError::getField)
				.distinct()
				.collect(Collectors.toList()));
			
//			model.addAttribute("produit", produit);
			return "produit/form";
		}
		
		this.srvProduit.add(produit);
		
		return "redirect:/produit";
	}
	
	@GetMapping("/editer/{id}")
	@PreAuthorize("hasPermission(#id, 'PRODUIT', 'RO')")
	public String edit(@PathVariable int id, Model model) {
		return "redirect:/produit";
	}
	
	@PostMapping("/editer/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasPermission(null, 'PRODUIT', 'RW') or hasPermission(#id, 'PRODUIT', 'RW')")
	public String edit(@PathVariable int id, BindingResult result, Model model) {
		return "redirect:/produit";
	}
	
	@ModelAttribute("demo")
	public String modelDemo() {
		return "Démo coucou";
	}
}