package tn.esprit.magasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.Client;
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
	public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
	return produitService.retrieveProduit(produitId);
	}
	@PostMapping("/add-produit/{stock-id}/{rayon-id}")
	@ResponseBody
	public Produit addProduit(@RequestBody Produit p, @PathVariable("stock-id") Long stockId,@PathVariable("rayon-id") Long rayonId ) {
	return produitService.addProduit(p, rayonId, stockId);
	}
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
	produitService.deleteProduit(produitId);
	}
	@PutMapping("/modify-produit/{stock-id}/{rayon-id}")
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit p, @PathVariable("stock-id") Long stockId,@PathVariable("rayon-id") Long rayonId ) {
	return produitService.updateProduit(p, rayonId, stockId);
	}
	
	@GetMapping("/get-best-catg")
	public String getBestCatg() {
	return produitService.getbestCategory();
	}

	@GetMapping("/nbr-total-produit")
	public String nbrTotalProduit() {
	return "le nombre total des produits est: "+produitService.nbrTotalProduit();
	}
	@GetMapping("/get-dp-by-libelle/{libelle}")
	public DetailProduit getdetailProduitByLibelle(@PathVariable("libelle") String Libelle) {
	return produitService.getdetailProduitByLibelle(Libelle);

	}
	

@GetMapping("/get-produit-by-categorie/{categorie}")
public List<Produit> getProduitByCategorie(@PathVariable("categorie") CategorieProduit categorie) {
return produitService.getProduitByLibelle(categorie);

}

}
