package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
