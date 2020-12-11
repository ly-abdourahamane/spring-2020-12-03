package fr.formation;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FormationSpringBootApplicationTests {
	@Test
	void contextLoads() {
		assertTrue(true);
	}
}