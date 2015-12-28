package br.com.votenorestaurante.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends EntityTemplate {

	@NotNull
	private String name;
	@NotNull
	private String email;

	public User() {
		super();
	}

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNotValid() {

		if (this.name == null || "".equals(this.name)) {
			return false;
		}
		if (this.email == null || "".equals(this.email)) {
			return false;
		}
		return true;
	}

}
