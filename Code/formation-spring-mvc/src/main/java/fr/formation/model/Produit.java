package fr.formation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Produit {
	private int id;
	private String label;
	private BigDecimal price;
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
}