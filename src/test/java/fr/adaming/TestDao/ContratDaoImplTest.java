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

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ContratDaoImplTest {

	@Autowired
	IContratDao csDao;
	
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
		assertEquals("vente", csDao.getAll().get(0).getType());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("vente", csDao.getById(1).getType());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		Contrat bImmoLIn = new Contrat("bilan", null);
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
		Contrat bImmoLIn = new Contrat(1, "location", null);
		csDao.update(bImmoLIn);
		assertEquals("location", csDao.getById(1).getType());
	}
	
}
