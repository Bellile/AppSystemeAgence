package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Agence;

@Repository
public class AgenceDaoImpl extends DaoGenericImpl<Agence> implements IAgenceDao {

	public AgenceDaoImpl() {
		clazz=Agence.class;
	}
	
	

}
