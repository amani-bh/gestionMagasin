package tn.esprit.magasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.services.IProduitService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;
	
	@GetMapping("/retrieve-all-Produits")
	@ResponseBody
	public List<Produit> getProduits() {
	List<Produit> produits = produitService.retrieveAllProduits();
	return produits;
	}
	
	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public Produit retrieveProduit(@PathVariable("detailProduit-id") Long produitId) {
	return produitService.retrieveProduit(produitId);
	}
}
