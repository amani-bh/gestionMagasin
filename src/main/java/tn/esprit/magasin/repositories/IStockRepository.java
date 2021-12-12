package tn.esprit.magasin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
	Stock findByLibelleStock(String libelleStock);

	@Query("SELECT p.stock.qte FROM Produit p WHERE p.idProduit=:idProduit")
	public int getQteStockByIdProduitJPQL(@Param("idProduit") Long idProduit);

    @Query("SELECT s FROM Stock s WHERE s.qte < s.qteMin")
    List<Stock> warnStock();
    
	@Query("SELECT p.stock FROM Produit p WHERE p.detailProduit.categorieProduit=:categorieProduit")
	public Stock getStockByCategorieProduit(@Param("categorieProduit") CategorieProduit categorieProduit);
    
    @Query("SELECT p.stock FROM Produit p where p.idProduit= :idProduit")
    Stock StockByProduit(@Param("idProduit") Long idProduit);

}
