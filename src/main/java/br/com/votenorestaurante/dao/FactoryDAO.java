package br.com.votenorestaurante.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.votenorestaurante.model.EntityTemplate;

@SuppressWarnings("deprecation")
public class FactoryDAO {

	protected SessionFactory sessionFactory;
	protected Session session;

	public FactoryDAO() {
		super();
		createInitialFactory();
	}

	private void createInitialFactory() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		this.sessionFactory = configuration.buildSessionFactory();
	}

	public Session getSession() {
		if (this.session == null || !this.session.isOpen()) {
			this.session = this.sessionFactory.openSession();
		}
		return this.session;
	}

	public <T extends EntityTemplate> DaoImpl<T> getDao(Class<T> clazz) {
		return new ReflectDao<T>(clazz, this);
	}
}
