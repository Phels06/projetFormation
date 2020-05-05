package projetFormation.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import projetFormation.config.AppConfig;
import projetFormation.entity.Annonce;
import projetFormation.entity.Note;
import projetFormation.repository.AnnonceRepository;
import projetFormation.service.AnnonceService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/application-context.xml" })
@ContextConfiguration(classes = { AppConfig.class })
public class TestAnnonce {

	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private AnnonceService annonceService;
	private static SimpleDateFormat sdf;

	@BeforeClass
	public static void initDateFormat() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Test
	public void testAnnonceRepository() {
		assertNotNull(annonceRepository);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertAnnonce() {
		Annonce a;
		try {
			a = new Annonce(sdf.parse("10/05/2020"), Note.N3);
			assertNull(a.getId());
			annonceRepository.save(a);
			assertNotNull(a.getId());
			assertTrue(annonceRepository.findById(a.getId()).isPresent());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testServiceAjoutAnnonce() {
		Annonce a;
		try {
			a = new Annonce(sdf.parse("10/05/2020"), Note.N5);
			annonceService.ajout(a);
			
			//assertTrue(annonceRepository.findById()(id)(a.getId()).isPresent());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testInsertAnnonceDateOnly() {
//		Annonce a;
//		try {
//			a = new Annonce(sdf.parse("10/05/2020"), null);
//			assertNull(a.getId());
//			annonceRepository.save(a);
//			assertNotNull(a.getId());
//			assertTrue(annonceRepository.findById(a.getId()).isPresent());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testInsertAnnonceNoteOnly() {
//		Annonce a;
//		a = new Annonce(null, Note.N3);
//		assertNull(a.getId());
//		annonceRepository.save(a);
//		assertNotNull(a.getId());
//		assertTrue(annonceRepository.findById(a.getId()).isPresent());
//	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testServiceAnnonceRecherche() {
		Annonce a;
		try {
			a = new Annonce(sdf.parse("10/05/2020"), Note.N3);
			annonceRepository.save(a);
			
			assertTrue(annonceService.recherche(a.getId()) != null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
