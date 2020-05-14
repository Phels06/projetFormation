package projetFormation.test;

import static org.junit.Assert.assertEquals;
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
import projetFormation.service.ChienService;

//Class de test executer avec une class particulière de Spring
//Traiter la classe comme un Bean
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/application-context.xml"})
@ContextConfiguration(classes = { AppConfig.class })
public class TestChien {

	@Autowired
	private ChienRepository chienRepository;

	@Autowired
	private ChienService chienService;

	@Test
	public void testRepository() {
		assertNotNull(chienRepository);
	}
	
	@Test
	public void testService() {
		assertNotNull(chienService);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienComplet() {
		Chien c1 = new Chien("chien", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		chienService.ajout(c1);
		assertNotNull(c1.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansSurnom() {
		Chien c1 = new Chien("", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		chienService.ajout(c1);
		assertNull(c1.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansSexe() {
		Chien c1 = new Chien("chien", null , 15, "photo", 5, "bulldog", 0);
		chienService.ajout(c1);
		assertNull(c1.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansAge() {
		Chien c1 = new Chien("chien", SexeChien.F , null, "photo", 5, "bulldog", 0);
		chienService.ajout(c1);
		assertNull(c1.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansPhoto() {
		Chien c1 = new Chien("chien", SexeChien.F , 15, "", 5, "bulldog", 0);
		chienService.ajout(c1);
		assertNotNull(c1.getId());
		assertEquals(c1.getPhoto(),"photo non defini");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansPoids() {
		Chien c1 = new Chien("chien", SexeChien.F , 15, "photo", null, "bulldog", 0);
		chienService.ajout(c1);
		assertNull(c1.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void AjoutChienSansRace() {
		Chien c1 = new Chien("chien", SexeChien.F , 15, "photo", 5, "", 0);
		chienService.ajout(c1);
		assertNotNull(c1.getId());
		assertEquals(c1.getRace(),"race non defini");
	}


	@Test
	@Transactional
	@Rollback(true)
	public void testServiceChienRecherche() {
		Chien c1 = new Chien("chien", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		chienRepository.save(c1);
		assertTrue(chienService.recherche(c1.getId()) != null);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testServiceChienMisAjour() {
		Chien c1 = new Chien("chien", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		chienRepository.save(c1);
		c1.setSurnom("chien 3");
		c1.setSexeChien(SexeChien.M);
		chienService.miseAjour(c1);
		assertEquals(c1.getSurnom(), "chien 3");
		assertEquals(c1.getSexeChien(), SexeChien.M);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testServiceChienRechercheParPersonne() {
		Chien c1 = new Chien("chien", SexeChien.F, 10, "photo", 5, "bulldog", 0);
		chienRepository.save(c1);
		assertTrue(chienService.rechercheTousParMaitre(c1.getId()) != null);
	}
	
	

}
