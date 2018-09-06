package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.Proprietaire;

@Service("proprietaireService")
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IDaoGeneric<Proprietaire> pDao;

	@Override
	public List<Proprietaire> getAll() {
		return pDao.getAll();
	}

	@Override
	public Proprietaire getById(int id) {
		// TODO Auto-generated method stub
		return pDao.getById(id);
	}

	@Override
	public Proprietaire add(Proprietaire p) {
		// TODO Auto-generated method stub
		return pDao.add(p);
	}

	@Override
	public Proprietaire update(Proprietaire p) {
		// TODO Auto-generated method stub
		return pDao.update(p);
	}

	@Override
	public void delete(int id) {
		pDao.delete(id);
		
	}

	

	

}
