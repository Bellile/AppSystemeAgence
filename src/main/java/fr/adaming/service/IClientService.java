package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public List<Client> getAll();
	
	public Client getById(int id);
	
	public Client add(Client cl);
	
	public Client update(Client cl);
	
	public int delete(int id);
	
}
