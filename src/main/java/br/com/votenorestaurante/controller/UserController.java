package br.com.votenorestaurante.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.UserRegister;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.Research;
import br.com.votenorestaurante.service.RestaurantRanking;
import br.com.votenorestaurante.service.UserRanking;

import java.util.List;

@Resource
public class UserController extends AbstractController {

    private Research research;

    public UserController(Result result, FactoryDAO factoryDAO, Research research) {
        super(factoryDAO, result);
        this.research = research;
    }

    @Get(value = "/vote-no-restaurante/user/list")
    public void list() {
        log.info("Carregando formulario do usuario");
        List<UserRegister> users = factoryDAO.getDao(UserRegister.class).list();

        if (users.size() >= 1) {
            result.include("message", "Por enquanto somente 1 usuário pode fazer a votação.");
            result.redirectTo(RankingController.class).list();
        } else {

            CalculateRanking calculateRanking = new CalculateRanking();
            List<RestaurantRanking> restaurants = calculateRanking.getRanking(research.getPolls());
            List<UserRanking> restaurantsByUser = calculateRanking.getRankingByUser(research.getPolls(), users);

            result.include("restaurants", restaurants);
            result.include("restaurantsByUser", restaurantsByUser);
        }

    }

    @Get("/vote-no-restaurante/user/save")
    public void save(UserRegister user) {
        if (user == null || !user.isNotValid()) {
            result.include("message", "Usuario invalido, preencha todos os campos");
            result.redirectTo(this).list();
        }

        log.info("Registrando usuario");
        factoryDAO.getDao(UserRegister.class).save(user);

        research.setUser(user);

        for (Poll poll : research.getPolls()) {
            factoryDAO.getDao(Poll.class).save(poll);
        }

        log.info("Redirecionando para o formulario de Ranking");
        result.redirectTo(RankingController.class).list();
    }

}
