package br.com.votenorestaurante.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "restaurant")
@TableGenerator(name = "restaurant_generator", table = "table_ids", pkColumnName = "table", 
				pkColumnValue = "restaurant_id", valueColumnName = "id_actual")
public class Restaurant extends EntityTemplate{
	
	private String name;
	private String category;
	private String description;
	private String imageId;

	public Restaurant() {
		super();
	}

	public Restaurant(String name, String category, String description) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}


@Override
public boolean equals(Object o){
	Restaurant rec = (Restaurant) o;
	if(rec.id.equals(this.id)){
		return true;
	}
	return false;
}
	
	
}
