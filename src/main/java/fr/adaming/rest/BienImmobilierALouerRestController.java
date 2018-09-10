package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.dao.IBienImmobilierALouerDao;
import fr.adaming.model.BienImmobilierALouer;
import fr.adaming.service.IBienImmobilierALouerService;

@RestController
@RequestMapping("/wsBl")
public class BienImmobilierALouerRestController {
	
	@Autowired
	IBienImmobilierALouerService blService;
	
	@RequestMapping(value="/liste", method=RequestMethod.GET, produces = "application/json")
	public List<BienImmobilierALouer> getAllBL(){
		return blService.getAll();
	}
	
	@RequestMapping(value="/recherche",  method = RequestMethod.GET, produces = "application/json" )
	public BienImmobilierALouer getBL(@RequestParam("pId") int id){
		return blService.getById(id);
	}
	
	
	@RequestMapping(value="/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
	public BienImmobilierALouer addBL(@RequestBody BienImmobilierALouer bl){
		
		System.out.println(bl.getLat());
		return blService.add(bl);
	}
	
	@RequestMapping(value="/modif",  method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BienImmobilierALouer updateBL(@RequestBody BienImmobilierALouer bl){
		return blService.update(bl);
	}
	
	@RequestMapping(value="/suppr/{pId}", method = RequestMethod.DELETE)
	public void deleteBL(@PathVariable("pId") int id){
		blService.delete(id);
	}

	@RequestMapping(value="/listeLoyer", method=RequestMethod.GET, produces = "application/json")
	public List<BienImmobilierALouer> getAllBLLoyer (@RequestParam("pLoyer")double loyer) {
		return blService.getLocationByLoyer(loyer);
	}
	
	@RequestMapping(value="/listeRegion", method=RequestMethod.GET, produces = "application/json")
	public List<BienImmobilierALouer> getAllBLRegion (@RequestParam("pRegion")String adresse) {
		return blService.getLocationByRegion(adresse);
	}
	
}
