package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmobilierALouerDao;
import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.BienImmobilierALouer;

@Service("bienlouerService")
@Transactional
public class BienImmobilierALouerServiceImpl implements IBienImmobilierALouerService {

	@Autowired
	private IBienImmobilierALouerDao blDao;

	
	//setter
	public void setBlDao(IBienImmobilierALouerDao blDao) {
		this.blDao = blDao;
	}

	@Override
	public List<BienImmobilierALouer> getAll() {
		
		return blDao.getAll();
	}

	@Override
	public BienImmobilierALouer getById(int id) {
		
		return blDao.getById(id);
	}

	@Override
	public BienImmobilierALouer add(BienImmobilierALouer bl) {
		
		return blDao.add(bl);
	}

	@Override
	public BienImmobilierALouer update(BienImmobilierALouer bl) {
		
		return blDao.update(bl);
	}

	@Override
	public void delete(int id) {
		blDao.delete(id);
		
	}
	
	

	

}
