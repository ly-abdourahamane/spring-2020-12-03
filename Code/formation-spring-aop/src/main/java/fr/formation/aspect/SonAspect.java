package fr.formation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class SonAspect {
	@Pointcut("execution(* fr.formation.musique.*.toString(..))")
	public void intercept() { }
	
	@Pointcut("@annotation(fr.formation.annotation.Log)")
	public void interceptLog() { }
	
	@Pointcut("within(fr.formation..*)")
	public void interceptPackage() { }
	
	@Before("intercept()")
	public void interceptToString() {
		System.out.println("Un toString va être appelé !!");
	}
	
	@After("intercept()")
	public void afterToString() {
		System.out.println("Un toString a été appelé.");
	}
	
	@Before("interceptLog()")
	public void beforeLog() {
		System.out.println("Un log va être appelé ...");
	}
	
	@Around("interceptLog()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) {
		System.out.println("Un log va remplacer ...");
		
		try {
			System.out.println(joinPoint.getSignature().getName());
			
			System.out.println(joinPoint.getTarget());
			Object o = joinPoint.proceed(joinPoint.getArgs());// C'est ça qui déclencherera la méthode initiale
			
//			if (o instanceof Guitare) {
//				//...	
//			}
			
			return o;
		}

		catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
}