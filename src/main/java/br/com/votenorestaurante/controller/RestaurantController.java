package br.com.votenorestaurante.controller;

import br.com.votenorestaurante.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @RequestMapping
    public ModelAndView find() {

        ModelAndView mv = new ModelAndView("restaurant/list");
        mv.addObject("restaurants", repository.findAll());
        return mv;
    }

}
