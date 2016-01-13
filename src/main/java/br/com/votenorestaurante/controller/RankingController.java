package br.com.votenorestaurante.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.UserRegister;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.RestaurantRanking;
import br.com.votenorestaurante.service.UserRanking;

import java.util.List;

@Resource
public class RankingController extends AbstractController {

	public RankingController(FactoryDAO factoryDAO, Result result) {
		super(factoryDAO, result);
	}

	@Get(value = "/vote-no-restaurante/ranking/save")
	public void list() {
		log.info("Carregando ranking de restaurantes");
		List<Poll> polls = factoryDAO.getDao(Poll.class).list();
		List<UserRegister> users = factoryDAO.getDao(UserRegister.class).list();
		CalculateRanking calculateRanking = new CalculateRanking();
		List<RestaurantRanking> restaurants = calculateRanking.getRanking(polls);
		List<UserRanking> restaurantsByUser = calculateRanking.getRankingByUser(polls, users);

		result.include("restaurants", restaurants);
		result.include("restaurantsByUser", restaurantsByUser);

	}

}
