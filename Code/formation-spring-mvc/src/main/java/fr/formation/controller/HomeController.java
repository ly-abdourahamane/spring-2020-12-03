package fr.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Produit;
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
	//Avec l'injection de dépendance, on demande à Spring : le model, la session user, etc.
	public String home(Model model, HttpSession session) {
		System.out.println(this.srvProduit.findAll());
//		return "/views/home.jsp";
		
		model.addAttribute("demo", "test");
		
		return "home"; //Possible grâce à la configuration qu'on a faite
		
//		return "redirect:/produit"; //'redirect:' permet de rediriger avec un 300 HTTP
	}
	
	@GetMapping("/home-param")
//	public String homeWithParam(HttpServletRequest req) {
	public String homeWithParam(
			@RequestParam(value = "username", defaultValue = "default", required = false) String param,
			@RequestParam(value = "username2", defaultValue = "default2", required = false) String param2,
			@RequestParam String username,
			@RequestParam int a,
			Model model
		) {
//		String param = req.getParameter("username");
		
		System.out.println(a);
		model.addAttribute("utilisateur", username);
		
		return "home";
	}
	
	@GetMapping({ "/home-variable/{a}", "/home-variable/{username}/{a}" })
	public String homeWithVariable(
			@PathVariable(required = false) String username,
			@PathVariable int a,
			Model model
		) {
//		String param = req.getParameter("username");
		
		System.out.println(a);
		model.addAttribute("utilisateur", username);
		
		return "home";
	}
	
	@GetMapping("/home-data-binding")
//	public String homeDataBinding(
//			@RequestParam String label,
//			@RequestParam BigDecimal price) {
	//...?label=Test&price=42&id=77&fournisseur.id=12
	public String homeDataBinding(Produit produit, @RequestParam List<String> label) {
//		Produit produit = new Produit();
		
//		produit.setLabel(label);
//		produit.setPrice(price);
		
		System.out.println(label);
		System.out.println(produit.getId() + " + " + produit.getLabel() + " - " + produit.getPrice());
		System.out.println(produit.getFournisseur().getId());
		
		return "home";
	}
}