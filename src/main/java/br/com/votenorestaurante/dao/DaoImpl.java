package br.com.votenorestaurante.dao;

import java.util.List;

import br.com.votenorestaurante.model.EntityTemplate;
import br.com.votenorestaurante.model.EntityImpl;



public interface DaoImpl <T extends EntityTemplate>{

	public void save(EntityImpl entity);
	public List<T> list();
	public T getById(Long id);
	
}
