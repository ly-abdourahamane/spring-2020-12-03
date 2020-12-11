package fr.formation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/connexion")
	public String login() {
		return "connexion";
	}
	
	@GetMapping("/deco")
	public String disconnect(HttpSession session) {
		session.invalidate(); //Détruire la session
		
		return "redirect:/connexion";
	}
}