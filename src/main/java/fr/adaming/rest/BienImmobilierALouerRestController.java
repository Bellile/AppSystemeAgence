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

@RestController
@RequestMapping("/wsbl")
public class BienImmobilierALouerRestController {
	
	@Autowired
	IBienImmobilierALouerDao blService;
	
	@RequestMapping(value="/listeBL", method=RequestMethod.GET, produces = "application/json")
	public List<BienImmobilierALouer> getAllBL(){
		return blService.getAll();
	}
	
	@RequestMapping(value="/getBL",  method = RequestMethod.GET, produces = "application/json" )
	public BienImmobilierALouer getBL(@RequestParam("pId") int id){
		
		return blService.getById(id);
	}
	
	
	@RequestMapping(value="/addBL", method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
	public BienImmobilierALouer addBL(@RequestBody BienImmobilierALouer bl){
		return blService.add(bl);
	}
	
	@RequestMapping(value="/updateBL",  method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public BienImmobilierALouer updateBL(@RequestBody BienImmobilierALouer bl){
		return blService.update(bl);
	}
	
	@RequestMapping(value="/deleteBL/{pId}", method = RequestMethod.DELETE)
	public void deleteBL(@PathVariable int id){
		blService.delete(id);
	}
	
	
	
	

}
