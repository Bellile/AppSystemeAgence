package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDao;
import fr.adaming.model.BienImmobilierAVendre;

@Service("bienVendreService")
@Transactional
public class BienImmobilierAVendreServiceImpl implements IBienImmobilierAVendreService {

	@Autowired
	private IDao<BienImmobilierAVendre, Integer> bvService;

	// setter

	public void setBvService(IDao<BienImmobilierAVendre, Integer> bvService) {
		this.bvService = bvService;
	}

	@Override
	public List<Class<BienImmobilierAVendre>> getAll() {

		return bvService.getAll();
	}

	@Override
	public Class<BienImmobilierAVendre> getById(Integer id) {
	
		return bvService.getById(id);
	}

	@Override
	public Class<BienImmobilierAVendre> add(BienImmobilierAVendre bv) {
		
		return bvService.add(bv);
	}

	@Override
	public Class<BienImmobilierAVendre> update(BienImmobilierAVendre bv) {
	
		return bvService.update(bv);
	}

	@Override
	public int delete(BienImmobilierAVendre bv) {
		
		return bvService.delete(bv);
	}

}
