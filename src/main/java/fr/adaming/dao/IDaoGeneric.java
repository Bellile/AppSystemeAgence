package fr.adaming.dao;

import java.io.Serializable;
import java.util.List;

public interface IDaoGeneric<T> {
	
	public List<T> getAll();
	public T getById(int id);
	public T add(T t);
	public T update(T t);
	public void delete(int id);
}
