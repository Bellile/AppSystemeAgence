package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	
	public List<Proprietaire> getAll();
	public Proprietaire getById(int id);
	public Proprietaire add(Proprietaire p);
	public Proprietaire update(Proprietaire p);
	public void delete(int id);
	
}
