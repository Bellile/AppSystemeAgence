package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Responsable;

@Repository
public class ResponsableDaoImpl extends DaoGenericImpl<Responsable> implements IResponsableDao{
	public ResponsableDaoImpl() {
		clazz=Responsable.class;
	}
}
