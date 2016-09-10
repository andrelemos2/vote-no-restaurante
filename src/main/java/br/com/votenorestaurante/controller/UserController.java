package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.UserRegister;
import br.com.votenorestaurante.service.CalculateRanking;
import br.com.votenorestaurante.service.Research;
import br.com.votenorestaurante.service.RestaurantRanking;
import br.com.votenorestaurante.service.UserRanking;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class UserController extends AbstractController {

	private Research research;

	public UserController(ModelAndView result, FactoryDAO factoryDAO, Research research) {
		super(factoryDAO, result);
		this.research = research;
	}

	@RequestMapping(value = "/vote-no-restaurante/user/list", method = RequestMethod.GET)
	public ModelAndView list(RedirectAttributes attributes) {
		log.info("Carregando formulario do usuario");
		List<UserRegister> users = factoryDAO.getDao(UserRegister.class).list();

		ModelAndView mv = new ModelAndView();

		if (users.size() >= 1) {
			attributes.addFlashAttribute("message", "Por enquanto somente 1 usuário pode fazer a votação.");

			mv.setViewName("redirect:/ranking/list");

			return mv;
		} else {

			CalculateRanking calculateRanking = new CalculateRanking();
			List<RestaurantRanking> restaurants = calculateRanking.getRanking(research.getPolls());
			List<UserRanking> restaurantsByUser = calculateRanking.getRankingByUser(research.getPolls(), users);

			mv.addObject("restaurants", restaurants);
			mv.addObject("restaurantsByUser", restaurantsByUser);
		}
		return mv;

	}

	@RequestMapping(value = "/vote-no-restaurante/user/save", method = RequestMethod.GET)
	public ModelAndView save(UserRegister user, RedirectAttributes attributes) {

		ModelAndView mv = new ModelAndView();
		if (user == null || !user.isNotValid()) {
			attributes.addFlashAttribute("message", "Usuario invalido, preencha todos os campos");
			mv.setViewName("redirect:/user/list");

			return mv;
		}

		log.info("Registrando usuario");
		factoryDAO.getDao(UserRegister.class).save(user);

		research.setUser(user);

		for (Poll poll : research.getPolls()) {
			factoryDAO.getDao(Poll.class).save(poll);
		}

		log.info("Redirecionando para o formulario de Ranking");
		mv.setViewName("redirect:/ranking/list");
		return mv;
	}

}
