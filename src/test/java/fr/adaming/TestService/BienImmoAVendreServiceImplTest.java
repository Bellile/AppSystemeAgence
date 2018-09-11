package fr.adaming.TestService;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.BienImmobilierAVendre;
import fr.adaming.service.IBienImmobilierAVendreService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/application-context.xml")
public class BienImmoAVendreServiceImplTest {

	@Autowired
	IBienImmobilierAVendreService bvService;
	
	@Test
//	@Ignore
	@Transactional
	public void testUpdateDispo () {
		BienImmobilierAVendre bvOut= bvService.getById(2);
		bvOut.setStatut("achete");
		bvService.updateDispo(bvOut);
		
		assertEquals("achete", bvService.getById(2).getStatut());
	}
	
	@Test
//	@Ignore
	@Transactional
	public void testUpdateDispoOther () {
		BienImmobilierAVendre bvOut= bvService.getById(2);
		bvOut.setStatut("achete");
		bvService.updateDispo(bvOut);
		
		assertEquals("appartement", bvService.getById(2).getTypeBien());
	}
	
	
}
