package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;
import fr.adaming.model.Responsable;

public interface IContratDao extends IDaoGeneric<Contrat>{

	public List<Contrat> getContratByResponsable(int id);
	
}
