package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}
