package br.com.votenorestaurante.service;

import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CalculateRanking {

	public List<RestaurantRanking> getRanking(List<Poll> polls) {
		HashMap<Restaurant, Integer> ranking = new HashMap<Restaurant, Integer>();
		List<RestaurantRanking> listScore = new ArrayList<RestaurantRanking>();

		if (polls != null) {
			for (Poll poll : polls) {
				if (ranking.containsKey(poll.getRestaurant())) {
					int pont = ranking.get(poll.getRestaurant());
					ranking.put(poll.getRestaurant(), pont + 1);
				} else {
					ranking.put(poll.getRestaurant(), 1);
				}
			}
		}
		for (Restaurant restaurant : ranking.keySet()) {
			listScore.add(new RestaurantRanking(restaurant, ranking.get(restaurant)));
		}

		Collections.sort(listScore);
		return listScore;
	}
}
