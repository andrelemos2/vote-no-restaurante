package br.com.votenorestaurante.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "poll")
@TableGenerator(name = "poll_generator", table = "table_ids", pkColumnName = "table", 
				pkColumnValue = "poll_id", valueColumnName = "id_actual")
public class Poll extends EntityTemplate{

	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "userregister_id")
	private UserRegister userregister;
	private Date date;

	@Transient
	private Restaurant otherRestaurant;

	public Poll() {
		super();
	}

	public Poll(Restaurant restaurant, Restaurant otherRestaurant, UserRegister userregister, Date date) {
		super();
		this.restaurant = restaurant;
		this.userregister = userregister;
		this.date = date;
		this.otherRestaurant = otherRestaurant;
	}

	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public UserRegister getUser() {
		return userregister;
	}

	public void setUser(UserRegister userregister) {
		this.userregister = userregister;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Restaurant getOtherRestaurant() {
		return otherRestaurant;
	}

	public void setOtherRestaurant(Restaurant otherRestaurant) {
		this.otherRestaurant = otherRestaurant;
	}

	public boolean isPolled(Restaurant restaurant1, Restaurant restaurant2) {
		if ((this.restaurant.equals(restaurant1) && this.otherRestaurant.equals(restaurant2))
				|| (this.restaurant.equals(restaurant2) && this.otherRestaurant.equals(restaurant1))) {
			return true;
		}
		return false;
	}

}
