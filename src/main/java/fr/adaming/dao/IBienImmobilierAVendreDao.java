package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilierAVendre;

public interface IBienImmobilierAVendreDao extends IDaoGeneric<BienImmobilierAVendre>{

	public List<BienImmobilierAVendre> getVenteByLoyer(double prix);
	
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse);
	
}
