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
	public void testInsert() {
		Personne personne1 = new Personne("testPrenom","testNom",new Inscription("toto@hotmail.fr", "AeerR"),Civilite.M,new Adresse(1, "testRue", "testCP", "testVille"));
		personneService.ajout(personne1);
//		personneRepository.save(personne1);
//		personneService.ajout(personne1);
//		personneService.miseAjour(personne1);
//		assertTrue(personneService.recherche(personne1.getId()) != null);
//		assertTrue(personneRepository.findById(personne1.getId()) != null);
	}

}
