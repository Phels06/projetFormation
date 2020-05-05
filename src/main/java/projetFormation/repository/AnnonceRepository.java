package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.entity.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}