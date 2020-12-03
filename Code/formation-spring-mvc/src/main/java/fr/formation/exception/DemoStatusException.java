package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Pas le droit...")
public class DemoStatusException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}