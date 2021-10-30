package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.DetailProduit;

@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {

}
