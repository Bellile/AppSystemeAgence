package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T, PK extends Serializable> {
	
	public List<Class<T>> getAll();
	public Class<T> getById(PK id);
	public Class<T> add(T t);
	public Class<T> update(T t);
	public void delete(T t);
}
