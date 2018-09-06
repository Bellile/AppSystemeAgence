package fr.adaming.dao;

import fr.adaming.model.BienImmobilierAVendre;

public class BienImmobilierAVendreDaoImpl extends DaoGenericImpl<BienImmobilierAVendre> implements IBienImmobilierAVendreDao{
	
	public BienImmobilierAVendreDaoImpl(){
		clazz=BienImmobilierAVendre.class;
	}

}
