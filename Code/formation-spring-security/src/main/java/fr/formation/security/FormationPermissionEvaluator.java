package fr.formation.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component //-> On donne �a � SPRING
public class FormationPermissionEvaluator implements PermissionEvaluator {
	//hasPermission('PRODUIT', 'READ') -> PRODUIT = targetDomainObject, READ = permission
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		return authentication.getAuthorities()
			.stream()
			.anyMatch(a ->
					a.getAuthority().startsWith(targetDomainObject.toString().toUpperCase()) &&
					a.getAuthority().contains(permission.toString().toUpperCase()));
	}

	//hasPermission(#id, 'PRODUIT', 'READ') -> id = targetId, PRODUIT = targetType, READ = permission
	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
		// Ici on peut pr�voir de v�rifier si l'user a acc�s � un objet en particulier (avec son ID par exemple)
		return false;
	}
}