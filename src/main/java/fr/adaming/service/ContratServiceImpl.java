package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;
import fr.adaming.model.Responsable;

@Service("coService")
@Transactional
public class ContratServiceImpl implements IContratService{
	
	//transformation de l'asso
	@Autowired
	private IContratDao contratDao;

	@Override
	public List<Contrat> getAllContrats() {
		return contratDao.getAll();
	}

	@Override
	public Contrat getContratById(int id) {
		return contratDao.getById(id);
	}

	@Override
	public Contrat addContrat(Contrat c) {
		return contratDao.add(c);
	}

	@Override
	public Contrat updateContrat(Contrat c) {
		return contratDao.update(c);
	}

	@Override
	public void deleteContrat(int id) {
		contratDao.delete(id);
	}

	@Override
	public List<Contrat> getContratByResponsable(int id) {
		return contratDao.getContratByResponsable(id);
		
	}


}
