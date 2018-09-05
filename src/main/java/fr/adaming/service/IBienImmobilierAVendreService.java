package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilierAVendre;

public interface IBienImmobilierAVendreService {

	public List<Class<BienImmobilierAVendre>> getAll();
	public Class<BienImmobilierAVendre> getById(Integer id);
	public Class<BienImmobilierAVendre> add(BienImmobilierAVendre bv);
	public Class<BienImmobilierAVendre> update(BienImmobilierAVendre bv);
	public int delete(BienImmobilierAVendre bv);
	
	
}
