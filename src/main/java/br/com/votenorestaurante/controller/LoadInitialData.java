package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.dao.FactoryDAO;
import br.com.votenorestaurante.model.Restaurant;

public class LoadInitialData {

	public void loadRestaurants(FactoryDAO factoryDAO) {
		Restaurant restaurant1 = new Restaurant("Applebee's", "Casual Dining",
				"Faça o seu happy hour no Applebee's! Happy Hour do seu jeito, o lugar certo para se reunir!");
		Restaurant restaurant2 = new Restaurant("Burger King", "Hamburgueres", "A melhor perspectiva para sua fome");
		Restaurant restaurant3 = new Restaurant("Sabor do Nordeste", "Comidas Típica",
				"Gastronomia casual de pratos nordestinos diversos com sorvetes, doces regionais e música típica ambiente");
		Restaurant restaurant4 = new Restaurant("Mc Donald's", "Hamburgueres",
				"O McDonald's é a maior e mais conhecida empresa de serviço rápido de alimentação do mundo");
		Restaurant restaurant5 = new Restaurant("Kyodo", "Sushi",
				"Música ambiente, atendimento e é claro os melhores temakis, tudo perfeito!");

		factoryDAO.getDao(Restaurant.class).save(restaurant1);
		factoryDAO.getDao(Restaurant.class).save(restaurant2);
		factoryDAO.getDao(Restaurant.class).save(restaurant3);
		factoryDAO.getDao(Restaurant.class).save(restaurant4);
		factoryDAO.getDao(Restaurant.class).save(restaurant5);

	}

}
