package projetFormation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import projetFormation.config.AppConfig;
import projetFormation.entity.Adresse;
import projetFormation.entity.Annonce;
import projetFormation.entity.Chien;
import projetFormation.entity.Civilite;
import projetFormation.entity.Inscription;
import projetFormation.entity.Note;
import projetFormation.entity.Personne;
import projetFormation.entity.Postuler;
import projetFormation.entity.PostulerKey;
import projetFormation.repository.AnnonceRepository;
import projetFormation.repository.PersonneRepository;
import projetFormation.repository.PostulerRepository;
import projetFormation.service.PostulerService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/application-context.xml" })
@ContextConfiguration(classes = { AppConfig.class })
public class TestPostuler {

	@Autowired
	private PostulerRepository postulerRepository;
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private AnnonceRepository annonceRepository;
	@Autowired
	private PostulerService postulerService;

/////////////////////////////////////////REPOSITORY/////////////////////////////////////

	@Test
	public void testPostulerRepository() {
		assertNotNull(postulerRepository);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPostuler() {
		Personne pe = new Personne("testPrenom", "testNom", new Inscription("toto@hotmail.fr", "AeerR"), Civilite.M,
				new Adresse(1, "testRue", "testCP", "testVille"));
		personneRepository.save(pe);
		Annonce an = new Annonce();
		annonceRepository.save(an);
		Postuler p;
		p = new Postuler(new PostulerKey(pe, an));
		
		postulerRepository.save(p);
		assertNotNull(p.getId());
		assertTrue(postulerRepository.findById(p.getId()).isPresent());		
	}

//////////////////////////////////SERVICE//////////////////////////////

	@Test
	public void testPostulerService() {
		assertNotNull(postulerService);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testServiceAjoutPostuler() {
		Personne pe = new Personne("testPrenom", "testNom", new Inscription("toto@hotmail.fr", "AeerR"), Civilite.M,
				new Adresse(1, "testRue", "testCP", "testVille"));
		personneRepository.save(pe);
		Annonce an = new Annonce();
		annonceRepository.save(an);
		Postuler p;
		p = new Postuler(new PostulerKey(pe, an));
		
		assertTrue(postulerService.ajout(p));
		assertNotNull(p.getId());
		
		assertTrue(postulerRepository.findById(p.getId()).isPresent());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testServicePostulerRecherche() {
		Personne pe = new Personne("testPrenom", "testNom", new Inscription("toto@hotmail.fr", "AeerR"), Civilite.M,
				new Adresse(1, "testRue", "testCP", "testVille"));
		personneRepository.save(pe);
		Annonce an = new Annonce();
		annonceRepository.save(an);

		Postuler p;
		p = new Postuler(new PostulerKey(pe, an));
		System.out.println(postulerRepository.save(p));

		assertEquals(postulerRepository.findById(p.getId()).get(), postulerService.recherche(p.getId()));
	}

}
