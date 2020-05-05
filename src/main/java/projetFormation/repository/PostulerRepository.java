package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.entity.Postuler;
import projetFormation.entity.PostulerKey;

public interface PostulerRepository extends JpaRepository<Postuler, PostulerKey> {
}