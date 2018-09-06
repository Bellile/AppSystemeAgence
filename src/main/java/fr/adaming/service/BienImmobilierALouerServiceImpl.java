package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.BienImmobilierALouer;

@Service("bienlouerService")
@Transactional
public class BienImmobilierALouerServiceImpl implements IBienImmobilierALouerService {

	@Autowired
	private IDaoGeneric<BienImmobilierALouer, Integer> blService;

	// setter

	public void setBlService(IDaoGeneric<BienImmobilierALouer, Integer> blService) {
		this.blService = blService;
	}

	@Override
	public List<Class<BienImmobilierALouer>> getAll() {

		return blService.getAll();
	}

	@Override
	public Class<BienImmobilierALouer> getById(Integer id) {

		return blService.getById(id);
	}

	@Override
	public Class<BienImmobilierALouer> add(BienImmobilierALouer bl) {

		return blService.add(bl);
	}

	@Override
	public Class<BienImmobilierALouer> update(BienImmobilierALouer bl) {

		return blService.update(bl);
	}

	@Override
	public int delete(BienImmobilierALouer bl) {

		return blService.delete(bl);
	}

}
