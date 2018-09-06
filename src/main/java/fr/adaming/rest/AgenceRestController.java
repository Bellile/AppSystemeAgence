package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Agence;
import fr.adaming.service.IAgenceService;

@RestController
@RequestMapping("/agence")
public class AgenceRestController {

	//transformation de l'association
	@Autowired
	private IAgenceService agenceService;
	
	@RequestMapping(value="/listeAgence", method=RequestMethod.GET, produces="application/json")
	public List<Agence> getAllAg(){
		return agenceService.getAllAgences();
	}
	
	@RequestMapping(value="/rechercheAgence", method=RequestMethod.GET, produces="application/json")
	public Agence getAgById(@RequestParam("pId") int id) {
		return agenceService.getAgenceById(id);
	}
	
	@RequestMapping(value="/ajoutAgence", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Agence addAg(@RequestBody Agence a){
		return agenceService.addAgence(a);
	}
	
	@RequestMapping(value="/modifAgence", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Agence updateAg(@RequestBody Agence a) {
		return agenceService.updateAgence(a);
	}
	
	@RequestMapping(value="/supprAgence", method=RequestMethod.DELETE)
	public void deleteAg(@PathVariable("pId") int id) {
		agenceService.deleteAgence(id);
	}
	
	
}
