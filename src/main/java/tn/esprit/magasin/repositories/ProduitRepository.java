package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
