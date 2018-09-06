package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;

@Service("aService")
@Transactional
public class AgenceServiceImpl implements IAgenceService{
	
	//transformation de l'asso
	@Autowired
	private IAgenceDao agenceDao;

	@Override
	public List<Agence> getAllAgences() {
		return agenceDao.getAll();
	}

	@Override
	public Agence getAgenceById(int id) {
		return agenceDao.getById(id);
	}

	@Override
	public Agence addAgence(Agence a) {
		return agenceDao.add(a);
	}

	@Override
	public Agence updateAgence(Agence a) {
		return agenceDao.update(a);
	}

	@Override
	public void deleteAgence(int id) {
		agenceDao.delete(id);
		
	}



	

}
