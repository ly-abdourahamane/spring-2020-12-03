package fr.formation.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("within(@org.springframework.stereotype.Component *)"
			+ " || within(@org.springframework.stereotype.Controller *)"
//			+ " || within(@org.springframework.web.bind.annotation.RestController *)"
			+ " || within(@org.springframework.context.annotation.Configuration *)"
			+ " || within(@org.springframework.stereotype.Service *)")
	public void interceptStringBeans() { }
	
	@Pointcut("within(fr.formation..*)")
	public void interceptPackage() { }
	
	@Around("interceptStringBeans() || interceptPackage()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.print("Entrée dans " + joinPoint.getSignature().getName());
		System.out.println(" avec les paramètres " + Arrays.toString(joinPoint.getArgs()));
		
		try {
			Object result = joinPoint.proceed();// C'est ça qui déclencherera la méthode initiale
			
			System.out.print("Sortie de " + joinPoint.getSignature().getName());
			System.out.println(" avec le résultat : " + result);
			
			return result;
		}

		catch (Exception e) {
			System.out.println("ERREUR DANS LA METHODE " + joinPoint.getSignature().getName());
			e.printStackTrace();
		}
		
		return null;
	}
	
//	@Before("execution(* fr.formation.musique.IMusicien.*(..))")
//	public void beforeMusicienJouer() {
//		System.out.println("BEFORE JOUER");
//	}
	
	@Before("execution(* fr.formation.musique.Guitariste.abstractJouer(..))")
	public void beforeMusicienJouerAbstract() {
		System.out.println("BEFORE JOUER ABSTRACT");
	}
}