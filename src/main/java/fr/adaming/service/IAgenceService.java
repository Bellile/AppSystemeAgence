package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agence;

public interface IAgenceService {

	public List<Agence> getAllAgences();

	public Agence getAgenceById(int id);

	public Agence addAgence(Agence a);

	public Agence updateAgence(Agence a);

	public void deleteAgence(int id);

}
