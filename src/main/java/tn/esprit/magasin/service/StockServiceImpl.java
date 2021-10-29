package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.repository.StockRepository;

public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRepository.findById(id).orElse(null);
	}

}
