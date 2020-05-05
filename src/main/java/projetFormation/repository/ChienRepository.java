package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.entity.Chien;

public interface ChienRepository extends JpaRepository<Chien, Integer> {
}