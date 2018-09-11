package fr.adaming.TestService;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.BienImmobilierALouer;
import fr.adaming.service.IBienImmobilierALouerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class BienImmoALouerServiceImplTest {
	
	@Autowired
	IBienImmobilierALouerService blService;
	
	@Test
	@Ignore
	@Transactional
	public void testUpdateDispo () {

		BienImmobilierALouer bImmoLIn = blService.getById(2);
		bImmoLIn.setStatut("loue");
		blService.updateDispo(bImmoLIn);
		assertEquals("loue", blService.getById(2).getStatut());
	}

}
