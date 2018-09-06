package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilierAVendre;

@Repository
public class BienImmobilierAVendreDaoImpl extends DaoGenericImpl<BienImmobilierAVendre> implements IBienImmobilierAVendreDao{
	
	public BienImmobilierAVendreDaoImpl(){
		clazz=BienImmobilierAVendre.class;
	}

}
