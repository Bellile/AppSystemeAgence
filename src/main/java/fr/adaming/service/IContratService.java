package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {

	public List<Class<Contrat>> getAllContrats();

	public Class<Contrat> getContratById(Integer id);

	public Class<Contrat> addContrat(Contrat c);

	public Class<Contrat> updateContrat(Contrat c);

	public int deleteContrat(Contrat c);

}
