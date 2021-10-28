package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{

}
