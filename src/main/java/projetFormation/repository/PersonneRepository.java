package projetFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.entity.Personne;
import projetFormation.entity.Adresse;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
//	@Query("select p from Adresse p where p.ville=:ville ")
//	List<Personne> findParVille(@Param("ville") String ville);
	
	
	List<Personne> findAll();
}