package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;



public abstract class DaoGenericImpl<T> implements IDaoGeneric<T> {
	
	/** 1 : créer un entityManagerFactory */
	@PersistenceContext(unitName="PU")
	protected EntityManager em;

	protected Class<T> clazz;

	
	
	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<T> getAll() {
		String req="FROM "+clazz.getName();
		return em.createQuery(req).getResultList();
	}

	@Override
	public T getById(int id) {
		
		return em.find(clazz, id);
	}

	@Override
	public T add(T t) {
	
		em.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	public void delete(int id) {
		T t=this.getById(id);
		
		em.remove(t);
		
	}

	
	
	
	

}
