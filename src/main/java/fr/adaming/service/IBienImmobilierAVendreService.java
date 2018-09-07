package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierAVendre;

public interface IBienImmobilierAVendreService {

	public List<BienImmobilierAVendre> getAll();
	public BienImmobilierAVendre getById(int id);
	public BienImmobilierAVendre add(BienImmobilierAVendre bv);
	public BienImmobilierAVendre update(BienImmobilierAVendre bv);
	public void delete(int id);
	
	public List<BienImmobilierAVendre> getVenteByLoyer(double loyer);
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse);
	
}
