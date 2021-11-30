package tn.esprit.magasin.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Dashboard;
import tn.esprit.magasin.entity.DetailFacture;


public interface IDetailFactureRepository extends JpaRepository<DetailFacture, Long>{
@Query("select sum(df.prixTotal) from DetailFacture df where df.facture.client.categorieClient=:categorieClient and df.facture.dateFacture between :startDate and :endDate and df.facture.active=true")
float calculerChiffreAffaireMagasin(@Param("categorieClient") CategorieClient categorieClient,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
//@Query("SELECT sum(df.prixTotal) AS Y, EXTRACT(MONTH FROM df.createdAt) AS X FROM DetailFacture df GROUP BY EXTRACT(MONTH FROM df.createdAt) ORDER BY EXTRACT(MONTH FROM df.createdAt)")
@Query(value="SELECT sum(df.prix_total) as Y, EXTRACT(MONTH FROM df.created_at) as X FROM Detail_facture df GROUP BY EXTRACT(MONTH FROM df.created_at) ORDER BY EXTRACT(MONTH FROM df.created_at)", nativeQuery=true)
List<Dashboard> dashPrixDate();
}
