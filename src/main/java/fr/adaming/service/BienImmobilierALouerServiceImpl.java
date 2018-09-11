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

	@Override
	public List<BienImmobilierALouer> getLocationByLoyer(double loyer) {
		// TODO Auto-generated method stub
		return blDao.getLocationByLoyer(loyer);
	}

	@Override
	public List<BienImmobilierALouer> getLocationByRegion(String adresse) {
		// TODO Auto-generated method stub
		return blDao.getLocationByRegion(adresse);
	}

	@Override
	public BienImmobilierALouer updateDispo(BienImmobilierALouer bl) {
		// recuperer l'objet bien immo à louer à partir de son ID
		BienImmobilierALouer blOut=blDao.getById(bl.getId());
		
		//j'attribue au bien trouvé son nouveau statut
		blOut.setStatut(bl.getStatut());
		
		return blDao.update(blOut);
	}

}
