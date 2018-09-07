package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilierALouer;

public interface IBienImmobilierALouerDao extends IDaoGeneric<BienImmobilierALouer>{

	public List<BienImmobilierALouer> getLocationByLoyer(double loyer);
	
	public List<BienImmobilierALouer> getLocationByRegion(String adresse);
	
}
