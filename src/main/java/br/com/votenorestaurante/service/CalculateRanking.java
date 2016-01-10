package br.com.votenorestaurante.service;

import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.model.User;

import java.util.*;

public class CalculateRanking {

	public List<RestaurantRanking> getRanking(List<Poll> polls) {
		HashMap<Restaurant, Integer> ranking = new HashMap<Restaurant, Integer>();
		List<RestaurantRanking> listScore = new ArrayList<RestaurantRanking>();

		if (polls != null) {
			for (Poll poll : polls) {
				if (ranking.containsKey(poll.getRestaurant())) {
					int pontuation = ranking.get(poll.getRestaurant());
					ranking.put(poll.getRestaurant(), pontuation + 1);
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
	
	public List<UserRanking> getRankingByUser(List<Poll> polls, List<User> users) {
	
		Map<String, UserRanking> rankingByUser = new HashMap<String, UserRanking>();
		
		for (User user : users) {
			RestaurantRanking topRestaurantUser = getTopRestaurantUser(polls, user);
			UserRanking userRanking = new UserRanking();
			userRanking.setUser(user);
			userRanking.setCount(topRestaurantUser.getCount());
			userRanking.setRestaurant(topRestaurantUser.getRestaurant());
			
			rankingByUser.put(user.getEmail(), userRanking);
		}
		
		List<UserRanking> userRankingList = new ArrayList<UserRanking>();
		for (String userEmail : rankingByUser.keySet()) {
			userRankingList.add(rankingByUser.get(userEmail));
		}
		Collections.sort(userRankingList);
		return userRankingList;
	}

	private RestaurantRanking getTopRestaurantUser(List<Poll> polls, User user) {
		HashMap<Restaurant, Integer> rankingUser = new HashMap<Restaurant, Integer>();
		if (polls != null) {
			for (Poll poll : polls) {
				if (poll.getUser().equals(user)) {
					if (rankingUser.containsKey(poll.getRestaurant())) {
						int pontuation = rankingUser.get(poll.getRestaurant());
						rankingUser.put(poll.getRestaurant(), pontuation + 1);
					} else {
						rankingUser.put(poll.getRestaurant(), 1);
					}
				}
			}
		}
		List<RestaurantRanking> listScore = new ArrayList<RestaurantRanking>();

		for (Restaurant restaurant : rankingUser.keySet()) {
			listScore.add(new RestaurantRanking(restaurant, rankingUser.get(restaurant)));
		}

		//ordenando pela maior pontuação
		Collections.sort(listScore);

		return listScore.get(0);
	}

}
