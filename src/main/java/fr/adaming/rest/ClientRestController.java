package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/wsCl")
public class ClientRestController {
	
	@Autowired
	IClientService clService;
	
	
	@RequestMapping(value="/liste", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClient(){
		
		return clService.getAll();
	}
	
	@RequestMapping(value="/recherche", method = RequestMethod.GET, produces = "application/json")
	public Client getClient(@RequestParam ("pId") int id){
		return clService.getById(id);
	}
	
	
	@RequestMapping(value="/ajout", method = RequestMethod.POST, produces = "application/json", consumes = "application/json" )
	public Client addClient(@RequestBody Client cl){
		return clService.add(cl);
	}
	
	
	@RequestMapping(value="/modif",  method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public Client updateClient(@RequestBody Client cl){
		return clService.update(cl);
	}
	
	@RequestMapping(value="/suppr/{pId}",  method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable ("pId")int id){
		clService.delete(id);
	}
	
	
	
	
	

}
