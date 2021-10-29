package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Stock;

public interface StockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock s);

	Stock retrieveStock(Long id);
}
