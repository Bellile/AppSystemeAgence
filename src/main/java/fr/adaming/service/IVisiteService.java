package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {

public List<Visite> getAll();
	
	public Visite getById(int id);
	
	public Visite add(Visite v);
	
	public Visite update(Visite v);
	
	public void delete(int id);
}
