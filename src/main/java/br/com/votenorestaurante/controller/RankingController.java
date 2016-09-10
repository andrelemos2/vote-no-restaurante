package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.UserRegister;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.RestaurantRanking;
import br.com.votenorestaurante.service.UserRanking;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RankingController extends AbstractController {

	public RankingController(FactoryDAO factoryDAO, ModelAndView result) {
		super(factoryDAO, result);
	}

	@RequestMapping(value = "/vote-no-restaurante/ranking/save", method = RequestMethod.GET)
	public ModelAndView list() {
		log.info("Carregando ranking de restaurantes");
		List<Poll> polls = factoryDAO.getDao(Poll.class).list();
		List<UserRegister> users = factoryDAO.getDao(UserRegister.class).list();
		CalculateRanking calculateRanking = new CalculateRanking();
		List<RestaurantRanking> restaurants = calculateRanking.getRanking(polls);
		List<UserRanking> restaurantsByUser = calculateRanking.getRankingByUser(polls, users);

		ModelAndView mv = new ModelAndView();
		mv.addObject("restaurants", restaurants);
		mv.addObject("restaurantsByUser", restaurantsByUser);

		return mv;
	}

}
