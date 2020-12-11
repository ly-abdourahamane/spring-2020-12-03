package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.projection.Views;


@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	@JsonView(Views.Commons.class)
	private int id;
	
	@Column(name = "PRO_LABEL", length = 150, nullable = false)
//	@NotBlank(message = "pas vide !")
	@JsonView(Views.Produit.class)
	private String label;
	
	@Column(name = "PRO_PRICE", scale = 2, precision = 10, nullable = false)
//	@NotNull
//	@Positive
	@JsonView(Views.ProduitDetailled.class)
	private BigDecimal price;

	@Column(name = "PRO_CREATED_ON", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull
	@JsonView(Views.ProduitDetailled.class)
	private LocalDate createdOn;

	@Transient
	@JsonView(Views.ProduitDetailled.class)
	private Utilisateur utilisateur;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Produit() {
		this.utilisateur = new Utilisateur();

		this.utilisateur.setId(42);
		this.utilisateur.setUsername("Babar");
	}
	
	public Produit(String label, BigDecimal price) {
		this.label = label;
		this.price = price;
		this.createdOn = LocalDate.now();
	}
	
	@Override
	public String toString() {
		return this.label + " - " + this.price + " - " + this.createdOn;
	}
}