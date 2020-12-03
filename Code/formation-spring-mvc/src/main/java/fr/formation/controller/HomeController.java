package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.service.ProduitService;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {
	@Autowired
	private ProduitService srvProduit;
	
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	@RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	@GetMapping({ "", "/page1" })
//	@PostMapping({ "", "/page1" })
	public String home() {
		System.out.println(this.srvProduit.findAll());
//		return "/views/home.jsp";
		
		return "home"; //Possible grâce à la configuration qu'on a faite
		
//		return "redirect:/produit"; //'redirect:' permet de rediriger avec un 300 HTTP
	}
}