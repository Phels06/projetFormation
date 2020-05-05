package projetFormation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.entity.Personne;
import projetFormation.repository.PersonneRepository;

@Service
public class PersonneService {

	@Autowired
	private PersonneRepository personneRepository;

	public void ajout(Personne personne) {
		if (personne.getNom().isEmpty()) {
			personne.setNom("non defini");
		}
		personneRepository.save(personne);
	}

	public Personne miseAjour(Personne personne) {
		Optional<Personne> opt = personneRepository.findById(personne.getId());
		if (opt.isPresent()) {
			Personne personneEnBase = opt.get();
			if (personne.getNom() != null) {
				personneEnBase.setNom(personne.getNom());
			}
			if (personne.getAdresse() != null) {
				personneEnBase.setAdresse(personne.getAdresse());
			}
			personneEnBase.setCapacite(personne.getCapacite());
			personneEnBase.setFormation(personne.getFormation());
			personneRepository.save(personneEnBase);
			return personneEnBase;
		} else {
			// personneRepository.save(personne);// on insert
			return null;
		}
		// throw new NoPersonneFoundException();

	}

	public Personne recherche(Integer id) {
		Optional<Personne> opt=personneRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

}
