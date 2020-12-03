package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.service.ProduitService;

@RequestMapping
public class HomeController {
	@Autowired
	private ProduitService srvProduit;
	
	@GetMapping("/home")
	public String home() {
		System.out.println(this.srvProduit.findAll());
		return "home.jsp";
	}
}