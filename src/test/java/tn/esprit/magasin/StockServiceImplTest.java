package tn.esprit.magasin;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.services.StockServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {

	@Autowired
	StockServiceImpl stockService;
	@Test
	public void testAddStock() {
	//List<Stock> stocks = stockService.retrieveAllStocks();
	//int expected=stocks.size();
	Stock s = new Stock();
	s.setLibelleStock("stock test");
	s.setQte(10);
	s.setQteMin(100);
	Stock savedStock= stockService.addStock(s);

	//assertEquals(expected+1, stockService.retrieveAllStocks().size());
	assertNotNull(savedStock.getLibelleStock());
	stockService.deleteStock(savedStock.getIdStock());
	}
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock();
		s.setLibelleStock("test");
		s.setQte(5);
		s.setQteMin(10);
		Stock savedStock= stockService.addStock(s);
	    stockService.deleteStock(savedStock.getIdStock());
	    Stock deletedStock=stockService.retrieveStock(savedStock.getIdStock());
	    assertNull(deletedStock);     
	     
	}
}
