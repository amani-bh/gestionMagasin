package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.DetailFacture;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture, Long> {

}
