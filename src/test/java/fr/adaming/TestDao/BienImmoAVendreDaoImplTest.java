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

import fr.adaming.dao.IBienImmobilierAVendreDao;
import fr.adaming.model.Adresse;
import fr.adaming.model.BienImmobilierAVendre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class BienImmoAVendreDaoImplTest {

	@Autowired
	IBienImmobilierAVendreDao bImmoVDao;
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllLoyerSize () {
		double prix = 18250.25;
		assertEquals(1, bImmoVDao.getVenteByPrix(prix).size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllRegionSize () {
		assertEquals(1, bImmoVDao.getVenteByRegion("Nantes").size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllSize () {
		assertEquals(1, bImmoVDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetAllFirst () {
		assertEquals("Maison", bImmoVDao.getAll().get(0).getDescription());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Maison", bImmoVDao.getById(1).getDescription());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		BienImmobilierAVendre bImmoLIn = new BienImmobilierAVendre(null, null, 0, "Case", null, null, null, 0, null, new Adresse());
		bImmoVDao.add(bImmoLIn);
		assertEquals(2, bImmoVDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testDelSize () {
		bImmoVDao.delete(1);
		assertEquals(0, bImmoVDao.getAll().size());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testUpdateName () {
		BienImmobilierAVendre bImmoLIn = new BienImmobilierAVendre(1, null, null, 0, "Case", null, null, null, 0, null, new Adresse());
		bImmoVDao.update(bImmoLIn);
		assertEquals("Case", bImmoVDao.getById(1).getDescription());
	}
	
}
