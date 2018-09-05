package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {

public List<Class<Visite>> getAll();
	
	public Class<Visite> getById(Integer id);
	
	public Class<Visite> add(Visite v);
	
	public Class<Visite> update(Visite v);
	
	public int delete(Visite v);
}
