package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;

import fr.adaming.model.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clDao;

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return clDao.getAll();
	}

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return clDao.getById(id);
	}

	@Override
	public Client add(Client cl) {
		// TODO Auto-generated method stub
		return clDao.add(cl);
	}

	@Override
	public Client update(Client cl) {
		// TODO Auto-generated method stub
		return clDao.update(cl);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return clDao.delete(id);
	}
	
}
