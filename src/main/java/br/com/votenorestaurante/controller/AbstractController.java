package br.com.votenorestaurante.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import br.com.votenorestaurante.dao.FactoryDAO;

public class AbstractController implements ControllerImpl {

	protected FactoryDAO factoryDAO;
	protected ModelAndView result;
	static Logger log = Logger.getLogger(AbstractController.class.getName());

	public AbstractController(FactoryDAO factoryDAO, ModelAndView result) {
		this.factoryDAO = factoryDAO;
		this.result = result;
	}


}
