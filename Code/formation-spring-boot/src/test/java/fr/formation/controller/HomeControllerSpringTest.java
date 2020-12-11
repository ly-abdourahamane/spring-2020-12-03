package fr.formation.controller;

import static org.junit.Assert.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.MockMvcConfigurer;
import org.springframework.web.context.WebApplicationContext;

import fr.formation.dao.ProduitRepository;
import fr.formation.model.Produit;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(HomeController.class)
//@DataJpaTest //Pour démarrer uniquement Data-Jpa
public class HomeControllerSpringTest {
//	@Autowired
//	private WebApplicationContext context;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProduitRepository daoProduit;
	
//	@BeforeEach
//	public void beforeEach() {
//		this.mockMvc = MockMvcBuilders
//						.webAppContextSetup(context)
//						.apply(SecurityMockMvcConfigurers.springSecurity())
//						.build();
//	}
	
	@Test
	void shouldReturn3xxRedirection() throws Exception {
		assertTrue(true);
		this.mockMvc
			.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}
	
	@Test
	@WithMockUser(roles = "NO_ROLE")
	void shouldReturnForbidden() throws Exception {
		assertTrue(true);
		this.mockMvc
			.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
	
	@Test
	@WithMockUser(roles = "ADMIN")
	void shouldReturnOk() throws Exception {
		assertTrue(true);
		
		List<Produit> produits = new ArrayList<>();
		
		produits.add(new Produit());
		Mockito.when(this.daoProduit.findAll()).thenReturn(produits);
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.get("/"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("home"));
		
		Mockito.verify(this.daoProduit, Mockito.atLeastOnce()).findAll();
	}
}