package projetFormation.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import projetFormation.config.AppConfig;
import projetFormation.entity.Adresse;
import projetFormation.entity.Avis;
import projetFormation.entity.Inscription;
import projetFormation.entity.Personne;
import projetFormation.service.AvisService;

public class TestAvis {
	private static AnnotationConfigApplicationContext ctx;
	@BeforeClass
	public static void ConnexionBDDSpring() {
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	
		Inscription ins = new Inscription();
		ins.setDateInscription(LocalDate.now());
		ins.setMail("monmail");
		ins.setMotdePasse("monmotdepase");
		
		Personne Ivan = new Personne();
		Ivan.setPrenom("Ivan");
		Ivan.setNom("Touré");
		ins.setDateInscription(LocalDate.now());
		ins.setMail("monmail");
		ins.setMotdePasse("monmotdepase");
		
		
		Ivan.setInscription(ins);
		
		Adresse add = new Adresse();
		add.setNumero(12);
		add.setRue("rue de Paris");
		add.setVille("Mougins");
		add.setCodePostal("54674");
		
		Ivan.setAdresse(add);
		
		Avis av = new Avis();
		av.setAvisMaitre("bonne balade");
		av.setPersonne(Ivan);
		
		AvisService as = new AvisService();
		as.ajout(av);
		
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

}
