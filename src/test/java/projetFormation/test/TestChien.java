package projetFormation.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import projetFormation.config.AppConfig;
import projetFormation.entity.Chien;
import projetFormation.entity.SexeChien;
import projetFormation.repository.ChienRepository;

//Class de test executer avec une class particulière de Spring
//Traiter la classe comme un Bean
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/application-context.xml"})
@ContextConfiguration(classes = {AppConfig.class})
public class TestChien {
	
	@Autowired
	private ChienRepository chienRepository;
	
	@Test
	public void test() {
		assertNotNull(chienRepository);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void insert() {
		Chien c1 = new Chien("chien", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		assertNull(c1.getId());
		chienRepository.save(c1);
		assertNotNull(c1.getId());
		assertTrue(chienRepository.findById(c1.getId()).isPresent());
	}
	
	

}
