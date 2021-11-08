package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.repositories.IStockRepository;

@Slf4j
@Service
public class StockServiceImpl implements IStockService{
	@Autowired
	IStockRepository repo;

	@Override
	public List<Stock> retrieveAllStocks() {
		return repo.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		return repo.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		return repo.save(s);
	}

	@Override
	public Stock retrieveStock(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		repo.deleteById(id);
		
	}

}
