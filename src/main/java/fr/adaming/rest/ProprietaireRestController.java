package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
@RequestMapping("/wsp")
public class ProprietaireRestController {

	@Autowired
	IProprietaireService pService;

	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAll() {
		return pService.getAll();
	}

	@RequestMapping(value = "/recherche", method = RequestMethod.GET, produces = "application/json")
	public Proprietaire getProprietaire(@RequestParam("pId") int id) {
		return pService.getById(id);
	}

	@RequestMapping(value = "/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Proprietaire addProprietaire(@RequestBody Proprietaire p) {
		return pService.add(p);

	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Proprietaire updateProprietaire(@RequestBody Proprietaire p){
		return pService.update(p);
	}

	@RequestMapping(value = "/suppr/{pId}", method = RequestMethod.DELETE)
	public void deleteProprietaire(@PathVariable("pId") int id) {

		pService.delete(id);
	}

}
