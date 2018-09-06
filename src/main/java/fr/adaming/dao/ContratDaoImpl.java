package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;

@Repository
public class ContratDaoImpl extends DaoGenericImpl<Contrat> implements IContratDao {

	public ContratDaoImpl() {
		clazz=Contrat.class;
	}
		
	
	
}
