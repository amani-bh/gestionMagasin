package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.repositories.IProduitRepository;
import tn.esprit.magasin.repositories.IStockRepository;

@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	IStockRepository stockRepository;

	@Autowired
	IProduitRepository produitRepository;

	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		// for (Stock stock : stocks) {
		// log.info("stock:" + stock);
		// }
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		log.info("stock ajoute");
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
		log.info("stock supprime");
		stockRepository.deleteById(id);

	}

	@Override
	public Stock getlibelleStock(String libelleStock) {
		return stockRepository.findByLibelleStock(libelleStock);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = produitRepository.findById(idProduit).orElse(null);
		Stock s = stockRepository.findById(idStock).orElse(null);
		p.setStock(s);
		produitRepository.save(p);
		log.info("assign Produit To Stock added successfully!");

	}

}
