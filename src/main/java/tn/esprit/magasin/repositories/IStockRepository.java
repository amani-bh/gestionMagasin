package tn.esprit.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
	Stock findByLibelleStock(String libelleStock);

	@Query("SELECT s.qte FROM Stock s join s.produits p WHERE p.id=:idProduit")
	public List<Stock> getQteStockByIdProduitJPQL(@Param("idProduit") Long idProduit);

}
