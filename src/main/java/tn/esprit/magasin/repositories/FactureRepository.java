package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
