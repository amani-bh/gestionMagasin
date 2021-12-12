package tn.esprit.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;

public interface IDetailProduitRepository extends JpaRepository<DetailProduit, Long>{
	
	@Query("select dp.produit from DetailProduit dp where dp.categorieProduit=:categorieProduit ")
	List<Produit> findProduitByCategorieProduit(@Param("categorieProduit") CategorieProduit categorieProduit);
}
