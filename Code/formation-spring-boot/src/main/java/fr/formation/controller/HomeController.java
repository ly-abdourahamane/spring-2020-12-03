package fr.formation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
//@Slf4j
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home() {
		this.logger.debug("HOME CTRL");
		
		return "home";
	}
}