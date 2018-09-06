package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.Visite;

@Service("vService")
@Transactional
public class VisiteServiceImpl implements IVisiteService{

	//Transformation de l'association UML en java
	@Autowired
	private IDaoGeneric<Visite> vDao;

	@Override
	public List<Visite> getAll() {
		// TODO Auto-generated method stub
		return vDao.getAll();
	}

	@Override
	public Visite getById(int id) {
		// TODO Auto-generated method stub
		return vDao.getById(id);
	}

	@Override
	public Visite add(Visite v) {
		// TODO Auto-generated method stub
		return vDao.add(v);
	}

	@Override
	public Visite update(Visite v) {
		// TODO Auto-generated method stub
		return vDao.update(v);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		vDao.delete(id);
	}
	


}
