package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.service.CombinationFactory;
import br.com.votenorestaurante.service.LoadInitialData;
import br.com.votenorestaurante.service.Research;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PollController extends AbstractController {

	private Research research;

	public PollController(ModelAndView result, FactoryDAO factoryDAO, Research research) {
		super(factoryDAO, result);
		this.research = research;
	}

	@RequestMapping(value = "/vote-no-restaurante/poll/list", method = RequestMethod.GET)
	public ModelAndView list() {
		log.info("Carregando listas inicias");
		loadInitialList();

		List<Restaurant> combinations = new CombinationFactory().getValidCombination(research.getRestaurantsToUser(),
				research.getPolls());

		ModelAndView mv = new ModelAndView();

		if (combinations == null) {
			if (research.getPolls() != null) {
				log.info("Votacao ok - Redirecionando para formulario do usuario");
				mv.setViewName("redirect:/user/list");
				return mv;
			} else {
				log.info("Usuario ok - Redirecionando para o ranking geral");
				mv.setViewName("redirect:/ranking/list");
				return mv;
			}

		}
		research.setRestaurantsInPoll(combinations);
		mv.addObject("restaurants", combinations);

		return mv;
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

	@RequestMapping(value = "/vote-no-restaurante/poll/save", method = RequestMethod.GET)
	public ModelAndView save(String id) {
		log.info("Voto realizado, salvando.");
		Restaurant restaurant = factoryDAO.getDao(Restaurant.class).getById(new Long(id));
		Restaurant otherRestaurant = getOtherRestaurant(research.getRestaurantsInPoll(), new Long(id));

		Poll poll = new Poll(restaurant, otherRestaurant, research.getUser(), new Date());
		research.addPoll(poll);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/poll/list");

		return mv;
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
