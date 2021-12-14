package tn.esprit.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{
@Query("select max(p.detailProduit.categorieProduit) from Produit p ")
String bestCategory();

@Query("select count(p) from Produit p")
int nbrTotalProduit();
@Query ("select p.detailProduit from Produit p where p.libelle=:libelle")
DetailProduit getdetailProduitByLibelle (@Param ("libelle") String libelle);

@Query ("select p from Produit p where p.detailProduit.categorieProduit=:categorie")
List<Produit> getProduitByLibelle (@Param ("categorie") CategorieProduit categorie);
}

