package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public List<Class<Client>> getAll();
	
	public Class<Client> getById(Integer id);
	
	public Class<Client> add(Client cl);
	
	public Class<Client> update(Client cl);
	
	public int delete(Client cl);
	
}
