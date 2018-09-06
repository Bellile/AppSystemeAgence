package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Responsable;
import fr.adaming.service.IResponsableService;

@RestController
@RequestMapping("/wsResp")
public class ResponsableRestController {
	
	@Autowired
	IResponsableService rService;

	@RequestMapping(value= "/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Responsable> getAll() {
		return rService.getAllResponsable();
	}
	
	@RequestMapping(value= "/recherche", method = RequestMethod.GET, produces = "application/json")
	public Responsable getById(@RequestParam("pId") int id) {
		return rService.getResponsableById(id);
	}


}
