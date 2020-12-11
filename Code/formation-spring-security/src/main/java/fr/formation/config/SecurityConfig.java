package fr.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import fr.formation.security.AuthService;

@Configuration
@EnableWebSecurity //ACTIVER LA SECURITE GLOBALE
//On peut l'enlever ici car positionné sur SecurityMethodConfig
//@EnableGlobalMethodSecurity(prePostEnabled = true) //ACTIVE LES ANNOTATIONS DE SECURITE
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthService srvAuth;
	
	@Autowired
	private PermissionEvaluator formationPermissionEvaluator;
	
	//GESTION DES ACCES GENERIQUES
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/**").hasAnyRole("ADMIN", "USER")
			.and()
			.formLogin()
				.loginPage("/connexion")
				.loginProcessingUrl("/process_connexion")
				.defaultSuccessUrl("/home", false)
				.failureUrl("/connexion?erreur=true")
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/deconnexion")
				.logoutSuccessUrl("/connexion")
			
//			.and().csrf().disable() //Désactiver CSRF
//			.httpBasic()
			;
	}
	
	//GESTION DES USERS (AUTHENTIFICATION)
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
//			.inMemoryAuthentication()
//			.withUser("admin").password("{noop}123456").roles("ADMIN")
//			.and()
//			.withUser("user").password("{noop}123456").roles("USER")
			.userDetailsService(this.srvAuth)
			;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		
		handler.setPermissionEvaluator(this.formationPermissionEvaluator);
		web.expressionHandler(handler);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
		return new BCryptPasswordEncoder();
	}
}