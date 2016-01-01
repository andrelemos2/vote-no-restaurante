package br.com.votenorestaurante.service;

import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.model.User;

public class UserRanking implements Comparable<UserRanking> {
	
	private User user;
	private int count;
	private Restaurant restaurant;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Override
	public int compareTo(UserRanking o) {
		return user.getName().compareTo(o.getUser().getName());
	}
	

}
