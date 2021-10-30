package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {

}
