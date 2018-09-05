package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;


@Repository
public class Dao<T, PK extends Serializable> implements IDao<T, Serializable> {
	
	/** 1 : créer un entityManagerFactory */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private Class<T> type;

	@Override
	public List<Class<T>> getAll() {
		
		EntityManager em = emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cr= cb.createQuery(type);
		TypedQuery<T> tq = em.createQuery(cr);
		
		return (List<Class<T>>) tq.getResultList();
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
		return (Class<T>) t;
	}

	@Override
	public int delete(T t) {
		EntityManager em = emf.createEntityManager();
		em.remove(t);
		if(em.find(type, t)==null){
			return 1;
		}else{
			return 0;
		}
		
	}

	
	
	
	
	

}
