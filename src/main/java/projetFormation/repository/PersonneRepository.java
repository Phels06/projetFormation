package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {	
	
	List<Personne> findAll();
	List<Personne> findByPrenom(String prenom);
	@Query("select p from Personne p where p.adresse.ville=:ville ")
	List<Personne> findByVille(@Param("ville") String ville);
	
}