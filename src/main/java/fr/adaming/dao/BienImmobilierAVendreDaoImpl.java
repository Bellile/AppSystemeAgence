package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilierAVendre;

@Repository
public class BienImmobilierAVendreDaoImpl extends DaoGenericImpl<BienImmobilierAVendre> implements IBienImmobilierAVendreDao{
	
	public BienImmobilierAVendreDaoImpl(){
		clazz=BienImmobilierAVendre.class;
	}

	@Override
	public List<BienImmobilierAVendre> getVenteByLoyer(double loyer) {
		//Création de la requête
		String req = "FROM BienImmobilierAVendre bv WHERE bv.loyer BETWEEN :pMin AND :pMax";
		
		//Récupération de la requête
		Query query = em.createQuery(req);
		
		//Paramétrage de la requête
		double min = loyer - loyer*0.05;
		double max = loyer + loyer*0.05;
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);
		
		return query.getResultList();
	}

	@Override
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse) {
		//Création de la requête
		String req = "FROM BienImmobilierAVendre bv WHERE WHERE bv.adresse.localite LIKE :pVille OR bv.adresse.pays LIKE :pPays OR bv.adresse.rue LIKE :pRue OR bv.adresse.cp LIKE :pCp";
		
		//Récupération de la requête
		Query query = em.createQuery(req);
		
		//Paramétrage de la requête
		String rech = "%" + adresse + "%";
		query.setParameter("pVille", rech);
		query.setParameter("pPays", rech);	
		query.setParameter("pRue", rech);	
		query.setParameter("pCp", rech);
		
		return query.getResultList();
	}

	
}
