package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierALouer;

public interface IBienImmobilierALouerService {
	
	
	public List<Class<BienImmobilierALouer>> getAll();
	public Class<BienImmobilierALouer> getById(Integer id);
	public Class<BienImmobilierALouer> add(BienImmobilierALouer bl);
	public Class<BienImmobilierALouer> update(BienImmobilierALouer bl);
	public int delete(BienImmobilierALouer bl);

}
