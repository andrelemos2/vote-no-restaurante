package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestaurantController {

    @RequestMapping("/restaurant/list")
    public Restaurant list() {
        return new Restaurant("teste", "categoria", "descricao", "1");
    }

}
