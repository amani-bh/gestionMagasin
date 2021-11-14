package tn.esprit.magasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.magasin.entities.Stock;
import tn.esprit.magasin.services.IStockService;

@RestController
@Api(tags = "Gestion de Stock ")
@RequestMapping("/stock")
public class StockRestController {

	@Autowired
	IStockService stockService;

	// http://localhost:8082/SpringMVC/stock/retrieve-all-stocks
	@GetMapping("/retrieve-all-stocks")
	@ApiOperation(value = "Récupérer la liste des stocks")
	@ResponseBody
	public List<Stock> getStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		return listStocks;
	}

	// http://localhost:8082/SpringMVC/stock/retrieve-stock/1
	@GetMapping("/retrieve-stock/{stock-id}")
	@ApiOperation(value = "Récupérer un stock par id")
	@ResponseBody
	public Stock retrieveStock(@PathVariable("stock-id") Long StockId) {
		return stockService.retrieveStock(StockId);
	}

	// http://localhost:8082/SpringMVC/stock/add-stock
	@PostMapping("/add-stock")
	@ApiOperation(value = "Ajouter un stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s) {
		Stock stock = stockService.addStock(s);
		return stock;
	}

	// http://localhost:8082/SpringMVC/stock/remove-stock/{stock-id}
	@DeleteMapping("/remove-stock/{stock-id}")
	@ApiOperation(value = "Supprimer un stock")
	@ResponseBody
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	// http://localhost:8082/SpringMVC/stock/modify-stock
	@PutMapping("/modify-stock")
	@ApiOperation(value = "Modifier un stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}
}