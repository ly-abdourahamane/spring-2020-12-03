package fr.formation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.ProduitRepository;


@Controller
//@Slf4j
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProduitRepository daoProduit;
	
	@GetMapping("/")
	public String home() {
		this.logger.debug(this.daoProduit.findAll().toString());
		this.logger.debug("HOME CTRL");
		
		return "home";
	}
}