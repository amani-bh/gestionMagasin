package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Rayon;

@Repository
public interface IRayonRepository extends JpaRepository<Rayon, Long> {

	@Query("SELECT p.rayon FROM Produit p where p.idProduit= :idProduit")
    Rayon RayonByProduit(@Param("idProduit") Long idProduit);
}
