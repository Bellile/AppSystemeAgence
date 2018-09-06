package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClasseStandardDao;

import fr.adaming.model.ClasseStandard;

@Service("csService")
@Transactional
public class ClasseStandardServiceImpl implements IClasseStandardService{
	
	//Transformation de l'association UML en java
	@Autowired
	private IClasseStandardDao csDao;

	@Override
	public List<ClasseStandard> getAll() {
		// TODO Auto-generated method stub
		return csDao.getAll();
	}

	@Override
	public ClasseStandard getById(int id) {
		// TODO Auto-generated method stub
		return csDao.getById(id);
	}

	@Override
	public ClasseStandard add(ClasseStandard cs) {
		// TODO Auto-generated method stub
		return csDao.add(cs);
	}

	@Override
	public ClasseStandard update(ClasseStandard cs) {
		// TODO Auto-generated method stub
		return csDao.update(cs);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		csDao.delete(id);
	}

	

}
