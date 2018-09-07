package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
@RequestMapping("/wsV")
public class VisiteRestController {

	@Autowired
	IVisiteService vService;
	
	@RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Visite> getAllVisites() {
		return vService.getAll();
	}

	@RequestMapping(value = "/recherche", method = RequestMethod.GET, produces = "application/json")
	public Visite getVisiteById(@RequestParam("pId") int id) {
		return vService.getById(id);
	}

	@RequestMapping(value = "/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Visite addVisite(@RequestBody Visite v) {
		return vService.add(v);

	}

	@RequestMapping(value="/modif", method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Visite updateVisite(@RequestBody Visite v){
		return vService.update(v) ;
	}

	@RequestMapping(value = "/suppr/{pId}", method = RequestMethod.DELETE)
	public void deleteVisite(@PathVariable("pId") int id) {
		vService.delete(id);
	}
	
}
