package fr.formation.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.formation.model.Utilisateur;

public class UtilisateurPrincipal implements UserDetails {
	private Utilisateur utilisateur;
	
	public UtilisateurPrincipal(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.utilisateur.isAdmin()) {
			//ROLE_? => Définir un rôle (hasRole('ADMIN') ou hasAuthority('ROLE_ADMIN')
			return Arrays.asList(
				new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("PRODUIT_READ_PRIVILEGES"),
				new SimpleGrantedAuthority("PRODUIT_WRITE_PRIVILEGES")
			);
			
			//Au chargement, on vérifie pour un user tous les objets auquel il a droit
			//Liste d'autorités = PRODUIT_WRITE_PRIVILEGES, PRODUIT_1_RO, PRODUIT_2_RW, PRODUIT_3_RW, PRODUIT_5_RW, ...
			
//			return Collections.singleton(new SimpleGrantedAuthority("PRODUIT_WRITE_PRIVILEGES"));
		}
		
		return Arrays.asList(
			new SimpleGrantedAuthority("ROLE_USER"),
			new SimpleGrantedAuthority("PRODUIT_READ_PRIVILEGES")
		);
	}

	@Override
	public String getPassword() {
		return this.utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		return this.utilisateur.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}