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
	private IDaoGeneric<Proprietaire, Integer> pDao;

	public void setpDao(IDaoGeneric<Proprietaire, Integer> pDao) {
		this.pDao = pDao;
	}

	@Override
	public List<Class<Proprietaire>> getAll() {
		
		return pDao.getAll();
	}

	@Override
	public Class<Proprietaire> getById(Integer id) {
		
		return pDao.getById(id);
	}

	@Override
	public Class<Proprietaire> add(Proprietaire p) {
		
		return pDao.add(p);
	}

	@Override
	public Class<Proprietaire> update(Proprietaire p) {
		
		return pDao.update(p);
	}

	@Override
	public int delete(Proprietaire p) {
		
		return pDao.delete(p);
	}

	

}
