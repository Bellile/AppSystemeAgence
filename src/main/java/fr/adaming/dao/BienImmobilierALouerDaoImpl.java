package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilierALouer;

@Repository
public class BienImmobilierALouerDaoImpl extends DaoGenericImpl<BienImmobilierALouer> implements IBienImmobilierALouerDao{
	
	public BienImmobilierALouerDaoImpl(){
		clazz = BienImmobilierALouer.class;
	}

}
