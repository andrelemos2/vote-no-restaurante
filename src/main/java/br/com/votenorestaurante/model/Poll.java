package br.com.votenorestaurante.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Poll extends EntityTemplate{

	
	@OneToOne
	private Restaurant restaurant;
	@OneToOne
	private User user;
	private Date date;

	@Transient
	private Restaurant otherRestaurant;
	
	

	

	public Poll() {
		super();
	}

	public Poll(Restaurant restaurant, Restaurant otherRestaurant, User user, Date date) {
		super();
		this.restaurant = restaurant;
		this.user = user;
		this.date = date;
		this.otherRestaurant = otherRestaurant;
	}

	
	
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
