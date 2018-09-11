package fr.adaming.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.BienImmobilierAVendre;
import fr.adaming.model.Contrat;
import fr.adaming.model.Responsable;

@Repository
public class ContratDaoImpl extends DaoGenericImpl<Contrat> implements IContratDao {

	public ContratDaoImpl() {
		clazz=Contrat.class;
	}

	@Override
	public List<Contrat> getContratByResponsable(int id) {
		
		//Cr�ation de la requ�te
				String req = "FROM Contrat co WHERE co.visite.responsable.id = :pId";
				
				//R�cup�ration de la requ�te
				Query query = em.createQuery(req);
				
				//Param�trage de la requ�te
				query.setParameter("pId", id);
				
				//v�rifications :
				List<Contrat> liste = query.getResultList();
				System.out.println("V�rification de la liste r�cup�r�e dans le DAO : ");
				for (Contrat co : liste){
					System.out.println(co.toString());
				}
				
				return query.getResultList();
				
		
	}
	
	
	
	
}
