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
		//Création de la requête
		String req = "FROM BienImmobilierALouer bl WHERE bl.loyer BETWEEN :pMin AND :pMax";
		
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
	public List<BienImmobilierALouer> getLocationByRegion(String adresse) {
		
		//Création de la requête
		String req = "FROM BienImmobilierALouer bl WHERE bl.adresse.localite LIKE :pVille OR bl.adresse.pays LIKE :pPays OR bl.adresse.rue LIKE :pRue OR bl.adresse.cp LIKE :pCp";
		
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

	@Override
	public List<BienImmobilierALouer> getByResp(int id) {
		
		//Création de la requête
		Query q = em.createNativeQuery("SELECT bl.* FROM biensimmobilieralouer as bl, visites as v, responsables as r WHERE bl.id_b = v.bl_id AND v.r_id = r.id_r AND r.id_r = ? ");
				
				
				
				//Paramétrage de la requête
				
				q.setParameter(1, id);
				
				List<BienImmobilierALouer> liste = q.getResultList();
				System.out.println("Test de la liste récup dans le DAO : ");
				for(BienImmobilierALouer bL : liste){
					System.out.println(bL.toString());
				}
				
				return q.getResultList();
	}

}
