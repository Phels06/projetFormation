package projetFormation.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.entity.Personne;
import projetFormation.repository.PersonneRepository;

@Service
public class PersonneService {
	
	private Boolean succes = true;
	
	private static final Pattern[] inputRegexes = new Pattern[2];
	private static final Pattern[] inputRegexesMail = new Pattern[1];

//	static {
//		inputRegexes[0] = Pattern.compile(".** [A-Z].** ");
//		inputRegexes[1] = Pattern.compile(".** [a-z].** ");
//	}
//
//	static {
//		inputRegexesMail[0] = Pattern.compile(".** [`[email protected]#$%^&** ()\\-__=+\\\\|\\[{\\]};:'\",<.>/?].** ");
//	}

	@Autowired
	private PersonneRepository personneRepository;

	
	
	
	public boolean ajout(Personne personne) {
		if (personne.getAdresse().getNumero() == null) {
			succes = false;
		}
		if (personne.getAdresse().getRue().isEmpty()) {
			succes = false;
		}
		if (personne.getAdresse().getVille().isEmpty()) {
			succes = false;
		}
		if (personne.getAdresse().getCodePostal().isEmpty()) {
			succes = false;
		}
		if (personne.getCivilite().getLabel().isEmpty()) {
			succes = false;
		}
		if (personne.getPrenom().isEmpty()) {
			succes = false;
		}
		if (personne.getNom().isEmpty()) {
			succes = false;
		}
		if (personne.getInscription().getMotdePasse().isEmpty()) {
			succes = false;
		}
//		for (Pattern inputRegex : inputRegexes) {
//			if (!inputRegex.matcher(personne.getInscription().getMotdePasse()).matches()) {
//				succes = false;
//			}
//		}
		if (personne.getInscription().getMail().isEmpty()) {
			succes = false;
		}
//		for (Pattern inputRegexesMail : inputRegexesMail) {
//			if (!inputRegexesMail.matcher(personne.getInscription().getMotdePasse()).matches()) {
//				succes = false;
//			}
//		}
		if (succes == true) {
			personneRepository.save(personne);
			System.out.println(succes);
		}
		System.out.println(succes);
		return succes;
	}

	

	public Personne miseAjour(Personne personne) {
		Optional<Personne> opt = personneRepository.findById(personne.getId());
		if (opt.isPresent()) {
			Personne personneEnBase = opt.get();
			if (personne.getAdresse().getNumero() != null) {
				personneEnBase.getAdresse().setNumero((personne.getAdresse().getNumero()));
			}
			if (personne.getAdresse().getRue() != null) {
				personneEnBase.getAdresse().setRue((personne.getAdresse().getRue()));
			}
			if (personne.getAdresse().getVille() != null) {
				personneEnBase.getAdresse().setVille((personne.getAdresse().getVille()));
			}
			if (personne.getAdresse().getCodePostal() != null) {
				personneEnBase.getAdresse().setCodePostal((personne.getAdresse().getCodePostal()));
			}
			if (personne.getCivilite().getLabel() != null) {
				personneEnBase.getCivilite().setLabel(personne.getCivilite().getLabel());
			}
			if (personne.getPrenom() != null) {
				personne.setPrenom(personne.getPrenom());
			}
			if (personne.getNom() != null) {
				personne.setNom(personne.getNom());
			}
			if (personne.getNom() != null) {
				personne.setNom(personne.getNom());
			}
			if (personne.getInscription().getMotdePasse() != null) {
				for (Pattern inputRegex : inputRegexes) {
					if (!inputRegex.matcher(personne.getInscription().getMotdePasse()).matches()) {
						throw new IllegalArgumentException();
					}
				}
				personneEnBase.getInscription().setMotdePasse((personne.getInscription().getMotdePasse()));
			}
			
			if (personne.getInscription().getMail() != null) {
				for (Pattern inputRegexesMail : inputRegexesMail) {
					if (!inputRegexesMail.matcher(personne.getInscription().getMotdePasse()).matches()) {
						throw new IllegalArgumentException();
					}
				}
				personneEnBase.getInscription().setMail((personne.getInscription().getMail()));
			}
			personneRepository.save(personneEnBase);
			return personneEnBase;
		} else {
			return null;
		}
	}

	
	
	public Personne recherche(Integer id) {
		Optional<Personne> opt = personneRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

}
