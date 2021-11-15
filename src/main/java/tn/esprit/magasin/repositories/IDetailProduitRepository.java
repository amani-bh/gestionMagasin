package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.DetailProduit;

public interface IDetailProduitRepository extends JpaRepository<DetailProduit, Long>{

}