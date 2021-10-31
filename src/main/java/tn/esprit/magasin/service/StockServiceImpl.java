package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.repository.StockRepository;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock stock : stocks) {
			log.info("stock:" + stock);
		}
		return stocks;
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
	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
		
	}

}
