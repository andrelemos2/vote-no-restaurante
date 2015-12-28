package br.com.votenorestaurante.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.model.Poll;

public class CombinationFactory {

	public List<Restaurant> getValidCombination(List<Restaurant> restaurants, List<Poll> polls) {
		List<Restaurant> listRestaurantFiltered = new ArrayList<Restaurant>();

		if (restaurants == null) {
			return null;
		}

		Collections.shuffle(restaurants);

		for (Restaurant restaurant1 : restaurants) {

			for (Restaurant restaurant2 : restaurants) {

				if (!isPolled(restaurant1, restaurant2, polls)) {
					if (restaurant1.equals(restaurant2)) {
						continue;
					}
					listRestaurantFiltered.add(restaurant1);
					listRestaurantFiltered.add(restaurant2);
					return listRestaurantFiltered;
				}

			}

		}

		return null;
	}

	private boolean isPolled(Restaurant restaurant1, Restaurant restaurant2, List<Poll> polls) {
		if (polls == null) {
			return false;
		}

		for (Poll poll : polls) {
			if (poll.isPolled(restaurant1, restaurant2)) {
				return true;
			}
		}
		return false;
	}

}
