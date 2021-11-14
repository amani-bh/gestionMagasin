package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.DetailProduit;

@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {

}
