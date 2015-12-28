package br.com.votenorestaurante.service;

import br.com.votenorestaurante.model.Restaurant;

public class RestaurantRanking implements Comparable<RestaurantRanking> {

	private Restaurant restaurant;
	private int count;

	public RestaurantRanking(Restaurant restaurant, int count) {
		super();
		this.restaurant = restaurant;
		this.count = count;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int compareTo(RestaurantRanking o) {
		if (this.count < o.getCount()) {
			return 1;
		}
		if (this.count > o.getCount()) {
			return -1;
		}
		return 0;
	}

}
