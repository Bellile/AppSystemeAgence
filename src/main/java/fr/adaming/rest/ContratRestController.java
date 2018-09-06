package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
@RequestMapping("/wsCo")
public class ContratRestController {
	
	//transformation de l'association
	@Autowired
	private IContratService contratService;
	
	@RequestMapping(value="/listeContrat", method=RequestMethod.GET, produces="application/json")
	public List<Contrat> getAllCo(){
		return contratService.getAllContrats();
	}
	
	@RequestMapping(value="/rechercheContrat", method=RequestMethod.GET, produces="application/json")
	public Contrat getCoById(@RequestParam("pId") int id) {
		return contratService.getContratById(id);
	}
	
	@RequestMapping(value="/ajoutContrat", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Contrat addCo(@RequestBody Contrat c) {
		return contratService.addContrat(c);
	}
	
	@RequestMapping(value="/modifContrat", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Contrat updateCo(@RequestBody Contrat c) {
		return contratService.updateContrat(c);
	}
	
	@RequestMapping(value="/supprContrat/{pId}", method=RequestMethod.DELETE)
	public void deleteCo(@PathVariable("pId") int id) {
		contratService.deleteContrat(id);
	}

}
