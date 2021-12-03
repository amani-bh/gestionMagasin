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
}
