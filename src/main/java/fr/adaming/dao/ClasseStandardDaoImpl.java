package fr.adaming.dao;

import org.springframework.stereotype.Repository;

import fr.adaming.model.ClasseStandard;

@Repository
public class ClasseStandardDaoImpl extends DaoGenericImpl<ClasseStandard> implements IClasseStandardDao {

	public ClasseStandardDaoImpl() {
		clazz=ClasseStandard.class;
	}

}
