package br.com.votenorestaurante.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "restaurant_id")
	private int id;

	@Column(name = "restaurant_name")
	private String name;

	@Column(name = "restaurant_category")
	private String category;

	@Column(name = "restaurant_description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
