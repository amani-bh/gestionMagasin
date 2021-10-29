package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
