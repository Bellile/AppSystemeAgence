package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agence;

public interface IAgenceService {

	public List<Class<Agence>> getAllAgence();

	public Class<Agence> getAgenceById(Integer id);

	public Class<Agence> add(Agence a);

	public Class<Agence> update(Agence a);

	public int delete(Agence a);

}
