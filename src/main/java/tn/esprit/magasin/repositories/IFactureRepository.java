package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long>{

}
