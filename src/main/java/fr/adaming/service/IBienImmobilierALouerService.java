package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierALouer;

public interface IBienImmobilierALouerService {
	
	
	public List<BienImmobilierALouer> getAll();
	public BienImmobilierALouer getById(int id);
	public BienImmobilierALouer add(BienImmobilierALouer bl);
	public BienImmobilierALouer update(BienImmobilierALouer bl);
	public void delete(int id);

}
