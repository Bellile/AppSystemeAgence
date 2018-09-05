package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class Dao<T, PK extends Serializable> implements IDao<T, Serializable> {
	
	/** 1 : créer un entityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private Class<T> type;

	@Override
	public List<Class<T>> getAll() {
		
		EntityManager em = emf.createEntityManager();
		
		
		return null;
	}

	@Override
	public Class<T> getById(Serializable id) {
		
		EntityManager em = emf.createEntityManager();
		return (Class<T>) em.find(type, id);
	}

	@Override
	public Class<T> add(T t) {
		EntityManager em = emf.createEntityManager();
		em.persist(t);
		
		return (Class<T>) t;
	}

	@Override
	public Class<T> update(T t) {
		EntityManager em = emf.createEntityManager();
		em.find(type, t);
		em.merge(t);
		return null;
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	

}
