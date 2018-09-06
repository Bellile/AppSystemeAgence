package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl extends DaoGenericImpl<Client> implements IClientDao{

	public ClientDaoImpl() {
		clazz=Client.class;
	}

	
	
}
