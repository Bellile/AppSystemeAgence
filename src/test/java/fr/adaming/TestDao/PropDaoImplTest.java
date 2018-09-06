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

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.Proprietaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class PropDaoImplTest {

	@Autowired
	IProprietaireDao csDao;
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllSize () {
		assertEquals(1, csDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllFirst () {
		assertEquals("Pierre", csDao.getAll().get(0).getNom());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Pierre", csDao.getById(1).getNom());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		Proprietaire bImmoLIn = new Proprietaire("Claude", null, null, null, new Adresse());
		csDao.add(bImmoLIn);
		assertEquals(2, csDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testDelSize () {
		csDao.delete(1);
		assertEquals(0, csDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdateName () {
		Proprietaire bImmoLIn = new Proprietaire("Claude", null, null, 1, null, new Adresse());
		csDao.update(bImmoLIn);
		assertEquals("Claude", csDao.getById(1).getNom());
	}
	
}
