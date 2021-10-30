package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Stock;

public interface IStockService {
	
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock s);

	Stock retrieveStock(Long id);
	
	void deleteStock(Long id);
}
