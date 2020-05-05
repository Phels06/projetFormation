package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
}