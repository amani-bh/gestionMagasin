package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
