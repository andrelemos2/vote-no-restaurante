package br.com.votenorestaurante.controller;

import java.util.List;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.RestaurantRanking;

@Resource
public class RankingController extends AbstractController {

	public RankingController(FactoryDAO factoryDAO, Result result) {
		super(factoryDAO, result);
	}

	public void list() {
		log.info("Carregando ranking de restaurantes");
		List<Poll> polls = factoryDAO.getDao(Poll.class).list();
		CalculateRanking calculateRanking = new CalculateRanking();
		List<RestaurantRanking> restaurants = calculateRanking.getRanking(polls);

		result.include("restaurants", restaurants);

	}

}
