package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//GESTION DES ACCES GENERIQUES
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/**").hasAnyRole("ADMIN", "USER")
			.and()
			.formLogin()
				.loginPage("/connexion")
				.loginProcessingUrl("/process_connexion") //MAPPING POST CREE PAR SPRING
				.defaultSuccessUrl("/home", false)
				.failureUrl("/connexion?erreur=true")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/deconnexion") //MAPPING POST CREE PAR SPRING
				.logoutSuccessUrl("/connexion")
			
//			.and().csrf().disable() //Désactiver CSRF
//			.httpBasic()
			;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}