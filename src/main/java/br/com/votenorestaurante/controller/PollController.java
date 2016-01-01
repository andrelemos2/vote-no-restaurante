package br.com.votenorestaurante.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.service.CombinationFactory;
import br.com.votenorestaurante.service.LoadInitialData;
import br.com.votenorestaurante.service.Research;

import java.util.Date;
import java.util.List;

@Resource
public class PollController extends AbstractController {

	private Research research;

	public PollController(Result result, FactoryDAO factoryDAO, Research research) {
		super(factoryDAO, result);
		this.research = research;
	}

	@Get(value = "/vote-no-restaurante/poll/list")
	public void list() {
		log.info("Carregando listas inicias");
		loadInitialList();

		List<Restaurant> combinations = new CombinationFactory().getValidCombination(research.getRestaurantsToUser(),
				this.research.getPolls());

		if (combinations == null) {
			if (research.getUser() != null) {
				log.info("Usuario ok - Redirecionando para o ranking geral");
				result.redirectTo(RankingController.class).list();
				return;
			} else {
				log.info("Votacao ok - Redirecionando para formulario do usuario");
				result.redirectTo(UserController.class).list();
				return;
			}

		}
		research.setRestaurantsInPoll(combinations);
		result.include("restaurants", combinations);
	}

	private void loadInitialList() {
		if (research.getRestaurantsToUser() == null) {
			List<Restaurant> restaurants = factoryDAO.getDao(Restaurant.class).list();
			if (restaurants == null || restaurants.isEmpty()) {
				LoadInitialData cInicial = new LoadInitialData();
				cInicial.loadRestaurants(factoryDAO);
				log.error("Lista de restaurantes nao cadastrada.");
				restaurants = factoryDAO.getDao(Restaurant.class).list();

			}
			research.setRestaurantsToUser(restaurants);
		}
	}

	@Get(value = "/vote-no-restaurante/poll/save")
	public void save(String id) {
		log.info("Voto realizado, salvando.");
		Restaurant restaurant = factoryDAO.getDao(Restaurant.class).getById(new Long(id));
		Restaurant otherRestaurant = getOtherRestaurant(research.getRestaurantsInPoll(), new Long(id));

		Poll poll = new Poll(restaurant, otherRestaurant, research.getUser(), new Date());
		research.addPoll(poll);
		result.redirectTo(PollController.class).list();

	}

	private Restaurant getOtherRestaurant(List<Restaurant> restaurants, Long selected) {
		for (Restaurant restaurant : restaurants) {
			if (!restaurant.getId().equals(selected)) {
				return restaurant;
			}
		}
		return null;
	}

}
