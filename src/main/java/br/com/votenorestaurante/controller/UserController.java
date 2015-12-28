package br.com.votenorestaurante.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.User;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.Research;
import br.com.votenorestaurante.service.RestaurantRanking;
import br.com.votenorestaurante.model.Poll;

@Resource
public class UserController extends AbstractController {

	private Research research;

	public UserController(Result result, FactoryDAO factoryDAO, Research research) {
		super(factoryDAO, result);
		this.research = research;
	}

	public void list() {
		log.info("Carregando formulario do usuario");
		CalculateRanking calculateRanking = new CalculateRanking();
		List<RestaurantRanking> restaurants = calculateRanking.getRanking(research.getPolls());

		result.include("restaurants", restaurants);
	}

	@Get("user/save")
	public void save(User user) {
		if (user == null || !user.isNotValid()) {
			result.include("message", "Usuario invalido, preencha todos os campos");
			result.redirectTo(UserController.class).list();
		}

		log.info("Registrando usuario");
		factoryDAO.getDao(User.class).save(user);

		research.setUser(user);

		for (Poll poll : research.getPolls()) {
			factoryDAO.getDao(Poll.class).save(poll);
		}

		log.info("Redirecionando para o formulario de Ranking");
		result.redirectTo(RankingController.class).list();
	}

}