package br.com.votenorestaurante.service;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.model.User;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Component
public class Research {

	private User user;
	private List<Poll> polls;
	private List<Restaurant> restaurantsToUser;
	private List<Restaurant> restaurantsInPoll;

	public Research() {

	}

	public Research(User user, List<Poll> polls) {
		super();
		this.user = user;
		this.polls = polls;
	}

	public List<Restaurant> getRestaurantsInPoll() {
		return restaurantsInPoll;
	}

	public void setRestaurantsInPoll(List<Restaurant> restaurantsInPoll) {
		this.restaurantsInPoll = restaurantsInPoll;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if (this.polls != null) {
			for (Poll poll : this.polls) {
				poll.setUser(user);
			}
		}
		this.user = user;
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public List<Restaurant> getRestaurantsToUser() {
		return restaurantsToUser;
	}

	public void setRestaurantsToUser(List<Restaurant> restaurantsToUser) {
		this.restaurantsToUser = restaurantsToUser;
	}

	public void addPoll(Poll poll) {
		if (this.polls == null) {
			this.polls = new ArrayList<Poll>();
		}
		this.polls.add(poll);
	}

}
