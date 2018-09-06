package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.ClasseStandard;
import fr.adaming.service.IClasseStandardService;


@RestController
@RequestMapping("/csws")
public class ClasseStandardRestController {

	@Autowired
	IClasseStandardService csService;

	@RequestMapping(value = "/listeCS", method = RequestMethod.GET, produces = "application/json")
	public List<ClasseStandard> getClasseStandard() {
		return csService.getAll();
	}
	
	@RequestMapping(value = "/getCS", method = RequestMethod.GET, produces = "application/json")
	public ClasseStandard getClasseStandardById(@RequestParam("pId") int id) {
		return csService.getById(id);
	}

	@RequestMapping(value = "/addCS", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ClasseStandard addClasseStandard(@RequestBody ClasseStandard cs) {
		return csService.add(cs);

	}

	@RequestMapping(value="/updateCS", method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ClasseStandard updateClasseStandard(@RequestBody ClasseStandard cs){
		return csService.update(cs) ;
	}

	@RequestMapping(value = "/deleteCS/{pId}", method = RequestMethod.DELETE)
	public void deleteVClasseStandard(@PathVariable("pId") int id) {
		csService.delete(id);
	}
	
}
