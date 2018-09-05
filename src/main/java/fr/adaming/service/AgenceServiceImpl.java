package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDao;
import fr.adaming.model.Agence;

@Service("aService")
@Transactional
public class AgenceServiceImpl implements IAgenceService{
	
	//transformation de l'asso
	@Autowired
	private IDao<Agence, Integer> agenceDao;

	@Override
	public List<Class<Agence>> getAllAgence() {
		return agenceDao.getAll();
	}

	@Override
	public Class<Agence> getAgenceById(Integer id) {
		return agenceDao.getById(id);
	}

	@Override
	public Class<Agence> add(Agence a) {
		return agenceDao.add(a);
	}

	@Override
	public Class<Agence> update(Agence a) {
		return agenceDao.update(a);
	}

	@Override
	public int delete(Agence a) {
		return agenceDao.delete(a);
	}


	

}
