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

import fr.adaming.dao.IClasseStandardDao;
import fr.adaming.model.ClasseStandard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClasseStandardDaoImplTest {

	@Autowired
	IClasseStandardDao csDao;
	
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
		assertEquals("Maison", csDao.getAll().get(0).getTypeBien());
	}

	@Test
	@Ignore
	@Transactional(readOnly=true)
	public void testGetByIdName () {
		assertEquals("Maison", csDao.getById(1).getTypeBien());
	}
	
	@Test
	@Ignore
	@Transactional
	@Rollback(true)
	public void testAddSize () {
		ClasseStandard bImmoLIn = new ClasseStandard(null, null, 50, 10);
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
		ClasseStandard bImmoLIn = new ClasseStandard(1, "case", null, 150, 0);
		csDao.update(bImmoLIn);
		assertEquals("case", csDao.getById(1).getTypeBien());
	}
	
}
