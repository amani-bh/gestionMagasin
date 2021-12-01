package tn.esprit.magasin.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Facture;

public interface IFactureRepository extends JpaRepository<Facture, Long>{
@Query("select f from Facture f where f.client.id= :idClient")
List<Facture> FacturesByClient(@Param("idClient") Long idClient);
@Query("select sum (f.montantFacture) from Facture f where f.client.categorieClient=:categorieClient and f.active=TRUE and f.dateFacture between :startDate and :endDate")
float calculer(@Param("categorieClient") CategorieClient categorieClient,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

}
