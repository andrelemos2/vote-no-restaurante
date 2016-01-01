package br.com.votenorestaurante.test;

import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.service.CombinationFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;


public class PollingTest extends TestCase {

    public PollingTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(PollingTest.class);
    }

    public void testApp() {
        Poll poll = new PollBuilder()
                .withRestaurant("Mc Donald's", "hamburgueres")
                .withRestaurant("Burger King", "hamburgueres")
                .withUser("Teste", "teste@teste.com.br")
                .building();

        assertNotNull(poll.getRestaurant());
    }


    public void testValidCombination() {

        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        List<Poll> polls = new ArrayList<Poll>();

        for (int i = 0; i < 5; i++) {
            Restaurant restaurant = new Restaurant();
            restaurant.setId(new Long(i + 1));
            restaurants.add(restaurant);
        }

        List<Restaurant> restaurantsList = null;

        int i = 0;
        do {
            CombinationFactory combinationFactory = new CombinationFactory();
            restaurantsList = combinationFactory.getValidCombination(restaurants, polls);

            if (restaurantsList != null) {
                Restaurant restaurant1 = restaurantsList.get(0);
                Restaurant restaurant2 = restaurantsList.get(1);


                polls.add(new Poll(restaurant1, restaurant2, null, null));
            }

            i++;
        } while (restaurantsList != null);

        assertEquals(11, i);

    }

}
