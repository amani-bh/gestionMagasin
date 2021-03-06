package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.Stock;

public interface IStockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock s);

	Stock retrieveStock(Long id);

	void deleteStock(Long id);

	Stock getlibelleStock(String libelleStock);

	void assignProduitToStock(Long idProduit, Long idStock);

	int getStocksByProduit(Long idProduit);

	List<Stock> warnStock();

	Stock getStockByCategorieProduit(CategorieProduit categorieProduit);
	
	Stock StockByProduit(Long idProduit);

}
