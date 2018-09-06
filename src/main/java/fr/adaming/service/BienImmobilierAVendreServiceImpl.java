package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.BienImmobilierAVendre;

@Service("bienVendreService")
@Transactional
public class BienImmobilierAVendreServiceImpl implements IBienImmobilierAVendreService {

	@Autowired
	private IDaoGeneric<BienImmobilierAVendre> bvDao;

	//setter pour l'injection dépendance
	public void setBvDao(IDaoGeneric<BienImmobilierAVendre> bvDao) {
		this.bvDao = bvDao;
	}

	@Override
	public List<BienImmobilierAVendre> getAll() {
		
		return bvDao.getAll();
	}

	@Override
	public BienImmobilierAVendre getById(int id) {
	
		return bvDao.getById(id);
	}

	@Override
	public BienImmobilierAVendre add(BienImmobilierAVendre bv) {
		
		return bvDao.add(bv);
	}

	@Override
	public BienImmobilierAVendre update(BienImmobilierAVendre bv) {
		
		return bvDao.update(bv);
	}

	@Override
	public void delete(int id) {
		bvDao.delete(id);
		
	}
	
	
	

	

}
