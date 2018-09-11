package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;
import fr.adaming.model.Responsable;

public interface IContratService {

	public List<Contrat> getAllContrats();

	public Contrat getContratById(int id);

	public Contrat addContrat(Contrat c);

	public Contrat updateContrat(Contrat c);

	public void deleteContrat(int id);
	
	public List<Contrat> getContratByResponsable(int id);

}
