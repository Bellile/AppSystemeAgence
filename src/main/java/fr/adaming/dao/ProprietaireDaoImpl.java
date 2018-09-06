package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl extends DaoGenericImpl<Proprietaire> implements IProprietaireDao{
	public ProprietaireDaoImpl() {
		clazz=Proprietaire.class;
	}
}
