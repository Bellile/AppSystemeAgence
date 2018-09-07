package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienImmobilierAVendre;

public interface IBienImmobilierAVendreDao extends IDaoGeneric<BienImmobilierAVendre>{

	public List<BienImmobilierAVendre> getVenteByPrix(double prix);
	
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse);
	
}
