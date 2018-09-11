package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierALouer;
import fr.adaming.model.BienImmobilierAVendre;

public interface IBienImmobilierAVendreService {

	public List<BienImmobilierAVendre> getAll();
	public BienImmobilierAVendre getById(int id);
	public BienImmobilierAVendre add(BienImmobilierAVendre bv);
	public BienImmobilierAVendre update(BienImmobilierAVendre bv);
	public void delete(int id);
	
	public List<BienImmobilierAVendre> getVenteByPrix(double prix);
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse);
	
	/**
	 * Methode pour modifier la disponibilit� d'un bien immo � vendre
	 * @param bv, un objet bien immobilier � vendre
	 * @return un objet bien immobilier � vendre
	 */
	public BienImmobilierAVendre updateDispo(BienImmobilierAVendre bv);
	
}
