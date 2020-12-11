package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.projection.Views;


@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID")
	@JsonView(Views.Commons.class)
	private int id;
	
	@Column(name = "UTI_USERNAME", length = 50, nullable = false)
	private String username;

	@Column(name = "UTI_PASSWORD", length = 300, nullable = false)
	private String password;

	@Column(name = "UTI_ADMIN", nullable = false)
	private boolean admin;

	@Column(name = "UTI_DESACTIVE", nullable = false)
	private boolean desactive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isDesactive() {
		return desactive;
	}

	public void setDesactive(boolean desactive) {
		this.desactive = desactive;
	}
}