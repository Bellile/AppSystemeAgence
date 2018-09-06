package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.dao.IResponsableDao;
import fr.adaming.model.Responsable;

@Service
@Transactional
public class ResponsableServiceImpl implements IResponsableService{
	
	//transformation de l'asso
	@Autowired
	private IResponsableDao rDao;

	@Override
	public List<Responsable> getAllResponsable() {
		
		return rDao.getAll();
	}

	@Override
	public Responsable getResponsableById(int id) {
		return rDao.getById(id);
	}

	@Override
	public Responsable addResponsable(Responsable r) {
		return rDao.add(r);
	}

	@Override
	public Responsable updateResponsable(Responsable r) {
		return rDao.update(r);
	}

	@Override
	public void deleteResponsable(int id) {
		rDao.delete(id);
		
	}
	

	



}
