package fr.formation.controller;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fr.formation.dao.ProduitRepository;
import fr.formation.model.Produit;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class HomeControllerMockitoTest {
	private MockMvc mockMvc;
	
	@Mock
	private ProduitRepository daoProduit;
	
	@InjectMocks
	private HomeController homeCtrl;
	
	@BeforeEach
	public void beforeEach() {
		this.mockMvc = MockMvcBuilders
						.standaloneSetup(homeCtrl)
						.build();
	}
	
	@Test
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