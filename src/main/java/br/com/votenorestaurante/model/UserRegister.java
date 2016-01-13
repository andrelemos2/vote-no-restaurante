package br.com.votenorestaurante.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "userregister")
@TableGenerator(name = "userregister_generator", table = "table_ids", pkColumnName = "table", 
				pkColumnValue = "userregister_id", valueColumnName = "id_actual")
public class UserRegister extends EntityTemplate {

	@NotNull
	private String name;
	@NotNull
	private String email;
	@OneToMany(mappedBy = "userregister",cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private List<Poll> polls;

	public UserRegister() {
		super();
	}

	public UserRegister(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserRegister(String name, String email, List<Poll> polls) {
		super();
		this.name = name;
		this.email = email;
		this.polls = polls;
	}

	public List<Poll> getPollRestaurants() {
		if (polls == null) {
			return Collections.emptyList();
		}
		return polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
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
