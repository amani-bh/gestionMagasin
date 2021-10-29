package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
