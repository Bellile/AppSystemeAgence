package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilierALouer;

@Repository
public class BienImmobilierALouerDaoImpl extends DaoGenericImpl<BienImmobilierALouer> implements IBienImmobilierALouerDao{
	
	public BienImmobilierALouerDaoImpl(){
		clazz = BienImmobilierALouer.class;
	}

	@Override
	public List<BienImmobilierALouer> getLocationByLoyer(double loyer) {
		//Cr�ation de la requ�te
		String req = "FROM BienImmobilierALouer bl WHERE bl.loyer BETWEEN :pMin AND :pMax";
		
		//R�cup�ration de la requ�te
		Query query = em.createQuery(req);
		
		//Param�trage de la requ�te
		double min = loyer - loyer*0.05;
		double max = loyer + loyer*0.05;
		query.setParameter("pMin", min);
		query.setParameter("pMax", max);
		
		return query.getResultList();
	}

	@Override
	public List<BienImmobilierALouer> getLocationByRegion(String adresse) {
		
		//Cr�ation de la requ�te
		String req = "FROM BienImmobilierALouer bl WHERE bl.adresse.localite LIKE :pVille OR bl.adresse.pays LIKE :pPays OR bl.adresse.rue LIKE :pRue OR bl.adresse.cp LIKE :pCp";
		
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

	@Override
	public List<BienImmobilierALouer> getByResp(int id) {
		
		//Cr�ation de la requ�te
				String req = "FROM BienImmobilierALouer bl WHERE bl.visite.responsable.id=:pId";
				
				//R�cup�ration de la requ�te
				Query query = em.createQuery(req);
				
				//Param�trage de la requ�te
				
				query.setParameter("pId", id);
				
				List<BienImmobilierALouer> liste = query.getResultList();
				System.out.println("Test de la liste r�cup dans le DAO : ");
				for(BienImmobilierALouer bL : liste){
					System.out.println(bL.toString());
				}
				
				return query.getResultList();
	}

}
