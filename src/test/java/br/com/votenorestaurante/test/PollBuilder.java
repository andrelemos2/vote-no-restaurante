package br.com.votenorestaurante.test;

import br.com.votenorestaurante.model.Poll;
import br.com.votenorestaurante.model.Restaurant;
import br.com.votenorestaurante.model.User;

/**
 * Created by andreasl on 28/12/15.
 */
public class PollBuilder {

    private Poll instance;

    public PollBuilder() {
        this.instance = new Poll();
    }

    public PollBuilder withRestaurant(String name, String category){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setCategory(category);
        this.instance.setRestaurant(restaurant);
        return this;
    }

    public PollBuilder withUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        this.instance.setUser(user);
        return this;
    }

    public Poll building() {
        return this.instance;
    }

}
