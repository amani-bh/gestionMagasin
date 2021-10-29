package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.DetailProduit;

public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long>{

}
