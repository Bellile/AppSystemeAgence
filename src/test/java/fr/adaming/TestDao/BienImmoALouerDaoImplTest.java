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

import fr.adaming.dao.IBienImmobilierALouerDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmobilierALouer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class BienImmoALouerDaoImplTest {

	@Autowired
	IBienImmobilierALouerDao bImmoLDao;
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllLoyerSize () {
		double loyer = 750.15;
		assertEquals(1, bImmoLDao.getLocationByLoyer(loyer).size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllRegionSize () {
		assertEquals(1, bImmoLDao.getLocationByRegion("Nantes").size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllSize () {
		assertEquals(1, bImmoLDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllFirst () {
		assertEquals("Appartement", bImmoLDao.getAll().get(0).getDescription());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Appartement", bImmoLDao.getById(1).getDescription());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		assertEquals(2, bImmoLDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testDelSize () {
		bImmoLDao.delete(1);
		assertEquals(0, bImmoLDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdateName () {
		assertEquals("studio", bImmoLDao.getById(1).getDescription());
	}
	
}
