package fr.adaming.TestDao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Agence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class AgenceDaoImplTest {

	@Autowired
	IAgenceDao aDao;
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllSize () {
		assertEquals(1, aDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllFirst () {
		assertEquals("Nantes", aDao.getAll().get(0).getNom());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Nantes", aDao.getById(1).getNom());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		Agence clIn = new Agence("Marseille", new Adresse());
		aDao.add(clIn);
		assertEquals(2, aDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testDelSize () {
		aDao.delete(1);
		assertEquals(0, aDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdateName () {
		Agence clIn = new Agence(1, "Rennes", new Adresse());
		aDao.update(clIn);
		assertEquals("Rennes", aDao.getById(1).getNom());
	}
	
}
