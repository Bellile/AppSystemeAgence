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

import fr.adaming.dao.IResponsableDao;
import fr.adaming.model.Responsable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class RespDaoImplTest {

	@Autowired
	IResponsableDao rDao;
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllSize () {
		assertEquals(1, rDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllFirst () {
		assertEquals("Bob", rDao.getAll().get(0).getNom());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Bob", rDao.getById(1).getNom());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		Responsable r = new Responsable("Marc", null, null, null, null);
		rDao.add(r);
		assertEquals(2, rDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testDelSize () {
		rDao.delete(1);
		assertEquals(0, rDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdateName () {
		Responsable r = new Responsable("Marc", null, null, 1, null, null);
		rDao.update(r);
		assertEquals("Marc", rDao.getById(1).getNom());
	}
	
}
