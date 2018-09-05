package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	
	public List<Class<Proprietaire>> getAll();
	public Class<Proprietaire> getById(Integer id);
	public Class<Proprietaire> add(Proprietaire p);
	public Class<Proprietaire> update(Proprietaire p);
	public int delete(Proprietaire p);
	
}
