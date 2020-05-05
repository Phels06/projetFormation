package projetFormation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.entity.Annonce;
import projetFormation.entity.Personne;
import projetFormation.entity.Postuler;
import projetFormation.entity.PostulerKey;
import projetFormation.repository.PostulerRepository;

@Service
public class PostulerService {

	@Autowired
	private PostulerRepository postulerRepository;

	public boolean ajout(Personne personne, Annonce annonce) {
		boolean succes = true;
		if (personne != null && annonce != null) {
			PostulerKey id = new PostulerKey(personne, annonce);
			Postuler postuler = new Postuler(id);
			postulerRepository.save(postuler);
		} else {
			succes = false;
		}
		return succes;
	}

//	public void ajout2(Postuler postuler) {
//		if (postuler.getId() != null) {
//			postulerRepository.save(postuler);
//		}
//	}

	public Postuler recherche(PostulerKey id) {
		Optional<Postuler> opt = postulerRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new IllegalArgumentException();
	}

}
