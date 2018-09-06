package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.Contrat;

@Service("coService")
@Transactional
public class ContratServiceImpl implements IContratService{
	
	//transformation de l'asso
	@Autowired
	private IDaoGeneric<Contrat, Integer> contratDao;

	@Override
	public List<Class<Contrat>> getAllContrats() {
		return contratDao.getAll();
	}

	@Override
	public Class<Contrat> getContratById(Integer id) {
		return contratDao.getById(id);
	}

	@Override
	public Class<Contrat> addContrat(Contrat c) {
		return contratDao.add(c);
	}

	@Override
	public Class<Contrat> updateContrat(Contrat c) {
		return contratDao.update(c);
	}

	@Override
	public int deleteContrat(Contrat c) {
		return contratDao.delete(c);
	}

}
