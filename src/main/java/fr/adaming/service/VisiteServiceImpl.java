package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDao;
import fr.adaming.model.Visite;

@Service("vService")
@Transactional
public class VisiteServiceImpl implements IVisiteService{

	//Transformation de l'association UML en java
	@Autowired
	private IDao<Visite, Integer> vDao;
	
	@Override
	public List<Class<Visite>> getAll() {
		return vDao.getAll();
	}

	@Override
	public Class<Visite> getById(Integer id) {
		return vDao.getById(id);
	}

	@Override
	public Class<Visite> add(Visite v) {
		return vDao.add(v);
	}

	@Override
	public Class<Visite> update(Visite v) {
		return vDao.update(v);
	}

	@Override
	public int delete(Visite v) {
		return vDao.delete(v);
	}

}
