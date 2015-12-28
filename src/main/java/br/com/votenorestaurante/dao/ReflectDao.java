package br.com.votenorestaurante.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;

import br.com.votenorestaurante.model.EntityTemplate;
import br.com.votenorestaurante.model.EntityImpl;

public class ReflectDao<T extends EntityTemplate> implements DaoImpl<T> {

	private FactoryDAO factoryDAO;
	private Class<T> clazz;

	public ReflectDao(Class<T> clazz, FactoryDAO factoryDAO) {
		this.clazz = clazz;
		this.factoryDAO = factoryDAO;
	}

	public void save(EntityImpl entity) {
		Transaction tx = this.factoryDAO.getSession().beginTransaction();
		this.factoryDAO.getSession().save(entity);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		Criteria criteria = this.factoryDAO.getSession().createCriteria(this.clazz);
		List<T> entities = criteria.list();
		return entities;
	}

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		return (T) this.factoryDAO.getSession().load(clazz, id);
	}

}
