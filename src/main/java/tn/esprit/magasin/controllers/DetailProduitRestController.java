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
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.services.IDetailProduitService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detailProduit")
public class DetailProduitRestController {

	@Autowired
	IDetailProduitService dProduitService;
	
	@GetMapping("/retrieve-all-detailProduits")
	@ResponseBody
	public List<DetailProduit> getDetailProduits() {
	List<DetailProduit> listDProduits = dProduitService.retrieveAllDetailProduits();
	return listDProduits;
	}
	
	@GetMapping("/retrieve-detail-produit/{detailProduit-id}")
	@ResponseBody
	public DetailProduit retrieveDetailProduit(@PathVariable("detailProduit-id") Long detailProduitId) {
	return dProduitService.retrieveDetailProduit(detailProduitId);
	}
	@PostMapping("/add-detailproduit")
	@ResponseBody
	public DetailProduit addProduit(@RequestBody DetailProduit dp ) {
	return dProduitService.addDetailProduit(dp);
	}
	@DeleteMapping("/remove-detailproduit/{detailProduit-id}")
	@ResponseBody
	public void removedProduit(@PathVariable("detailProduit-id") Long produitId) {
	dProduitService.deleteDetailProduit(produitId);
	}
	@PutMapping("/modify-detailproduit/{stock-id}/{rayon-id}")
	@ResponseBody
	public DetailProduit modifydetailProduit(@RequestBody DetailProduit dp) {
	return dProduitService.updateDetailProduit(dp);
	}
	
	@GetMapping("/produits-by-categorie/{categorie}")
	public List<Produit> getProduitByCategorieProduit(@PathVariable("categorie") CategorieProduit categorie) {
	return dProduitService.ProduitByCategorieProduit(categorie);
	}
	
}
