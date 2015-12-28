package br.com.votenorestaurante.controller;

import org.apache.log4j.Logger;
import br.com.caelum.vraptor.Result;
import br.com.votenorestaurante.dao.FactoryDAO;

public class AbstractController implements ControllerImpl {

	protected FactoryDAO factoryDAO;
	protected Result result;
	static Logger log = Logger.getLogger(AbstractController.class.getName());

	public AbstractController(FactoryDAO factoryDAO, Result result) {
		this.factoryDAO = factoryDAO;
		this.result = result;
	}


}
