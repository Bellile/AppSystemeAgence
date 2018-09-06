package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl extends DaoGenericImpl<Visite> implements IVisiteDao{
	
	public VisiteDaoImpl() {
		clazz=Visite.class;
	}

}
