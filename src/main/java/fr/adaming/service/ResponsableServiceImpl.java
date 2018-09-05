package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDao;
import fr.adaming.model.Responsable;

@Service("rService")
@Transactional
public class ResponsableServiceImpl implements IResponsableService{
	
	//transformation de l'asso
	@Autowired
	private IDao<Responsable, Integer> responsableDao;
	

	@Override
	public List<Class<Responsable>> getAllResponsables() {
		return responsableDao.getAll();
	}

	@Override
	public Class<Responsable> getResponsableById(Integer id) {
		return responsableDao.getById(id);
	}

	@Override
	public Class<Responsable> addResponsable(Responsable r) {
		return responsableDao.add(r);
	}

	@Override
	public Class<Responsable> updateResponsable(Responsable r) {
		return responsableDao.update(r);
	}

	@Override
	public int deleteResponsable(Responsable r) {
		return responsableDao.delete(r);
	}



}
