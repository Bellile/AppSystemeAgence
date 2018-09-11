package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierALouer;

public interface IBienImmobilierALouerService {
	
	
	public List<BienImmobilierALouer> getAll();
	public BienImmobilierALouer getById(int id);
	public BienImmobilierALouer add(BienImmobilierALouer bl);
	public BienImmobilierALouer update(BienImmobilierALouer bl);
	public void delete(int id);
	
	public List<BienImmobilierALouer> getLocationByLoyer(double loyer);	
	public List<BienImmobilierALouer> getLocationByRegion(String adresse);
	
	/**
	 * Methode pour modifier la disponibilit� d'un bien immo � louer
	 * @param bl, un objet bien immobilier � louer
	 * @return un objet bien immobilier � louer
	 */
	public BienImmobilierALouer updateDispo(BienImmobilierALouer bl);
	
	public List<BienImmobilierALouer> getByResp(int id);
	
}
