package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Rayon;

@Repository
public interface IRayonRepository extends JpaRepository<Rayon, Long> {

}
