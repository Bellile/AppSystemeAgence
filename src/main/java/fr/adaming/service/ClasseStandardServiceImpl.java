package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.ClasseStandard;

@Service("csService")
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService{
	
	//Transformation de l'association UML en java
	@Autowired
	private IDaoGeneric<ClasseStandard, Integer> csDao;

	@Override
	public List<Class<ClasseStandard>> getAll() {
		return csDao.getAll();
	}

	@Override
	public Class<ClasseStandard> getById(Integer id) {
		return csDao.getById(id);
	}

	@Override
	public Class<ClasseStandard> add(ClasseStandard cs) {
		return csDao.add(cs);
	}

	@Override
	public Class<ClasseStandard> update(ClasseStandard cs) {
		return csDao.update(cs);
	}

	@Override
	public int delete(ClasseStandard cs) {
		return csDao.delete(cs);
	}

}
