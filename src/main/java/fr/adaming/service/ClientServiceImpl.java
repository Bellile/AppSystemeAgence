package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoGeneric;
import fr.adaming.model.Client;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IDaoGeneric<Client, Integer> clDao;

	@Override
	public List<Class<Client>> getAll() {
		// TODO Auto-generated method stub
		return clDao.getAll();
	}

	@Override
	public Class<Client> getById(Integer id) {
		// TODO Auto-generated method stub
		return clDao.getById(id);
	}

	@Override
	public Class<Client> add(Client cl) {
		// TODO Auto-generated method stub
		return clDao.add(cl);
	}

	@Override
	public Class<Client> update(Client cl) {
		// TODO Auto-generated method stub
		return clDao.update(cl);
	}

	@Override
	public int delete(Client cl) {
		// TODO Auto-generated method stub
		return clDao.delete(cl);
	}
	
}
