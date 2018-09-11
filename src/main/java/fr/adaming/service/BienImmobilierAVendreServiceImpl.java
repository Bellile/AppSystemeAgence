package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienImmobilierAVendreDao;
import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.BienImmobilierAVendre;

@Service("bienVendreService")
@Transactional
public class BienImmobilierAVendreServiceImpl implements IBienImmobilierAVendreService {

	@Autowired
	private IBienImmobilierAVendreDao bvDao;

	//setter pour l'injection dépendance
	public void setBvDao(IBienImmobilierAVendreDao bvDao) {
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

	@Override
	public List<BienImmobilierAVendre> getVenteByPrix(double prix) {
		// TODO Auto-generated method stub
		return bvDao.getVenteByPrix(prix);
	}

	@Override
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse) {
		// TODO Auto-generated method stub
		return bvDao.getVenteByRegion(adresse);
	}

	@Override
	public BienImmobilierAVendre updateDispo(BienImmobilierAVendre bv) {
		// recuperer un bien immo à partir de l'id
		BienImmobilierAVendre bvIn=bvDao.getById(bv.getId());
		
		//attribuer au bien son nouveau statut
		bvIn.setStatut(bv.getStatut());
		
		return bvDao.update(bvIn);
	}

}
