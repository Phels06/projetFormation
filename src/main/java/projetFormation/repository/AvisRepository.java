package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.entity.Avis;

public interface AvisRepository extends JpaRepository<Avis, Integer> {
}