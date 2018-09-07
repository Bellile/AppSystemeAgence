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
	public List<BienImmobilierAVendre> getVenteByLoyer(double prix) {
		//Cr�ation de la requ�te
		String req = "FROM BienImmobilierAVendre bv WHERE bv.prix BETWEEN :pMin AND :pMax";
		
		//R�cup�ration de la requ�te
		Query query = em.createQuery(req);
		
		//Param�trage de la requ�te
		double min = prix - prix*0.05;
		double max = prix + prix*0.05;
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);
		
		return query.getResultList();
	}

	@Override
	public List<BienImmobilierAVendre> getVenteByRegion(String adresse) {
		//Cr�ation de la requ�te
		String req = "FROM BienImmobilierAVendre bv WHERE WHERE bv.adresse.localite LIKE :pVille OR bv.adresse.pays LIKE :pPays OR bv.adresse.rue LIKE :pRue OR bv.adresse.cp LIKE :pCp";
		
		//R�cup�ration de la requ�te
		Query query = em.createQuery(req);
		
		//Param�trage de la requ�te
		String rech = "%" + adresse + "%";
		query.setParameter("pVille", rech);
		query.setParameter("pPays", rech);	
		query.setParameter("pRue", rech);	
		query.setParameter("pCp", rech);
		
		return query.getResultList();
	}

	
}
