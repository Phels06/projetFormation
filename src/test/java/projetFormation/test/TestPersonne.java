package projetFormation.test;

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import projetFormation.config.AppConfig;
import projetFormation.entity.Adresse;
import projetFormation.entity.Civilite;
import projetFormation.entity.Inscription;
import projetFormation.entity.Personne;
import projetFormation.repository.PersonneRepository;
import projetFormation.service.PersonneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestPersonne {

	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private PersonneService personneService;
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneComplète() {
		Personne personne1 = new Personne("testPrenom","testNom",new Inscription("test@gmail.com", "Ree8rr"),Civilite.M,new Adresse(1, "testRue", "testCP", "testVille"));
		personneService.ajout(personne1);
		assertTrue(personneService.recherche(personne1.getId()) != null);
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneSansPrenom() {
		Personne personne2 = new Personne("","testttNom",new Inscription("test2@gmail.com", "Reeee8rr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}

	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneSansNom() {
		Personne personne2 = new Personne("testPrenom","",new Inscription("test2@gmail.com", "Reeee8rr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansEmail() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("", "Reeee8rr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurDansEmail() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gm*ail.com", "Reeee8rr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansMotDePasse() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", ""),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansMajusculeMotDePasse() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "e8e31eerr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansMinusculeMotDePasse() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "A8A3112121"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansChiffreMotDePasse() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "Aaaaazzrrr"),Civilite.MLLE,new Adresse(5, "testRueee", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansRue() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "Aaaaa88zzrrr"),Civilite.MLLE,new Adresse(1,"", "testttCP", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansCp() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "Aaaaa88zzrrr"),Civilite.MLLE,new Adresse(1,"testRueee", "", "testtttVille"));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertPersonneErreurSansVille() {
		Personne personne2 = new Personne("testPrenom","testttNom",new Inscription("test2@gmail.com", "Aaaa88azzrrr"),Civilite.MLLE,new Adresse(1,"testRueee", "testttCP", ""));
		personneService.ajout(personne2);
		assertNull(personne2.getId());
	}

	
	@Test
	@Transactional
	@Rollback(true)
	public void testMiseAJour1() {
		Personne personne2 = new Personne("PrenomUpdate","testnomUpdate",new Inscription("monemail@gmail.com", "Mon1MotDePasse"),Civilite.MLLE,new Adresse(4,"Rueee", "COOOOP", "Villlllllle"));
		personneRepository.save(personne2);
		personne2.setPrenom("prenom apres MAJ");
		personne2.getAdresse().setVille("Ville aprés MAJ");
		personneService.miseAjour(personne2);
		assertEquals(personne2.getPrenom(), "prenom apres MAJ");
		assertEquals(personne2.getAdresse().getVille(), "Ville aprés MAJ");
	}
	
	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testRechercheParVille() {
//		Personne personne1 = new Personne("testPrenom","testNom",new Inscription("test@gmail.com", "Ree8rr"),Civilite.M,new Adresse(1, "testRue", "testCP", "testVille"));
//		personneRepository.findParVille("testVille");
//		assertTrue(personneRepository.findParVille("testVille") != null);
//	}
	
	
}





