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
	public List<Contrat> getContratByResponsable(Responsable resp) {
		
		//Création de la requête
				String req = "FROM Contrat co WHERE co.visite.responsable.id = pId";
				
				//Récupération de la requête
				Query query = em.createQuery(req);
				
				//Paramétrage de la requête
				query.setParameter("pId", resp.getId());
				
				
				return query.getResultList();
		
	}
	
	
	
	
}
