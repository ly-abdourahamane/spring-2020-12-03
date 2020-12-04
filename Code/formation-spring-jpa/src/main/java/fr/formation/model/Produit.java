package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "produit")
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID")
	private int id;
	
	@Column(name = "PRO_LABEL", length = 150, nullable = false)
	@NotBlank(message = "pas vide !")
	private String label;

	
	@Column(name = "PRO_PRICE", scale = 10, precision = 2, nullable = false)
	@NotNull
	@Positive
	private BigDecimal price;

	
	@Column(name = "PRO_CREATED_ON", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdOn;

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

	public Produit() { }
	
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