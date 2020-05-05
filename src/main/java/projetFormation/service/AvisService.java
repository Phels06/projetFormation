package projetFormation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.entity.Avis;
import projetFormation.repository.AvisRepository;



@Service
public class AvisService {

	@Autowired
	private AvisRepository avisRepository;
	
	public void ajout(Avis avis) {
		if(avis.getAvisMaitre().length() >=50) { //on sauvegarde l'avis si il est supèrieur à 50 caractères
			avisRepository.save(avis);;
		}
	}
	
	
	public Avis miseAjourAvis (Avis avis) {
		Optional<Avis> opt = avisRepository.findById(avis.getId());
		if(opt.isPresent()) {
			Avis avisEnBase = opt.get();
			if(avis.getAvisMaitre().length() >=50) { //si j'ai un nouveau avis de 50 caractères , je modifie
				avisEnBase.setAvisMaitre(avis.getAvisMaitre());
			}
			avisRepository.save(avisEnBase);//sauvegarde
			return avisEnBase;
		}
		return null;
		
	}
	
	
	public Avis recherche(Integer id) {
	Optional<Avis> opt = avisRepository.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}
	throw new IllegalArgumentException();
}
	
	
}
