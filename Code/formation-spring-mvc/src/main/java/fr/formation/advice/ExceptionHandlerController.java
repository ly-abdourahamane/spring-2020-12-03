package fr.formation.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.formation.exception.DemoStatusException;

//@ControllerAdvice //Retourner une vue
@RestControllerAdvice //Retourner un flux REST
public class ExceptionHandlerController {
	@ExceptionHandler(DemoStatusException.class)
	public String demoHandler() {
		//je journalise...
		return "handler";
	}
}