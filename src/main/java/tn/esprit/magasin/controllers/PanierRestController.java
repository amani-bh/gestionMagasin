package tn.esprit.magasin.controllers;

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

import io.swagger.annotations.ApiOperation;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Panier;
import tn.esprit.magasin.services.IPanierService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/panier")
public class PanierRestController {

	@Autowired
	IPanierService panierService;
	

	@GetMapping("/retrieve-panier/{client-id}")
	@ResponseBody
	public Panier retrievePanier(@PathVariable("client-id") Long clientId) {
	return panierService.getPanierById(clientId);
	}
	
	@PostMapping("/add-panier/{client-id}")
	@ResponseBody
	public Panier addFacture(@PathVariable("client-id") Long clientId)
	{
	return panierService.add( clientId) ;
	}
	
	@DeleteMapping("/remove-from-panier/{panier-id}/{produit-id}")
	@ResponseBody
	public void removePanier(@PathVariable("panier-id") Long panierId,@PathVariable("produit-id") Long produitId) {
		panierService.deleteFromPanier(panierId, produitId);
	}
	
	@PutMapping("/modify-panier/{panier-id}/{produit-id}")
	@ResponseBody
	public void addToPanier(@PathVariable("panier-id") Long panierId,@PathVariable("produit-id") Long produitId) {
	 panierService.addProduitToPanier(panierId, produitId);
	}
}
