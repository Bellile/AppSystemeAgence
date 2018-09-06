package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/wscl")
public class ClientRestController {
	
	@Autowired
	IClientService clService;
	
	
	@RequestMapping(value="/listeCL",  method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClient(){
		
		return clService.getAll();
	}
	
	
	

}
