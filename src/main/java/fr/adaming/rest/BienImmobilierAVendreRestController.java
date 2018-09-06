package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilierAVendre;
import fr.adaming.service.IBienImmobilierAVendreService;

@RestController
@RequestMapping("/wsBv")
public class BienImmobilierAVendreRestController {
	
	@Autowired
	IBienImmobilierAVendreService bvService;
	
	@RequestMapping(value="/listeBV", method=RequestMethod.GET, produces = "application/json")
	public List<BienImmobilierAVendre> getAllBV(){
		return bvService.getAll();
	}
	
	@RequestMapping(value="/rechercheBV", method=RequestMethod.GET, produces = "application/json")
	public BienImmobilierAVendre getBV(@RequestParam ("pId") int id){
		return bvService.getById(id);
	}
	
	@RequestMapping(value="/ajoutBV",  method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BienImmobilierAVendre addBV(@RequestBody BienImmobilierAVendre bv){
		return bvService.add(bv);
	}
	
	@RequestMapping(value="/modifBV", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BienImmobilierAVendre updateBV(@RequestBody BienImmobilierAVendre bv){
		return bvService.update(bv);
	}
	
	@RequestMapping(value="supprBV/{pId}", method=RequestMethod.DELETE)
	public void delteBV(@PathVariable("pId") int id){
		bvService.delete(id);
	}
	
	
	

}
