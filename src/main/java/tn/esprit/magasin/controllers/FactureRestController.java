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

import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.services.IFactureService;

@RestController
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService factureService;


	@GetMapping("/retrieve-all-factures")
	@ResponseBody
	public List<Facture> getFactures() {
	List<Facture> listFactures = factureService.retrieveAllFactures();
	return listFactures;
	}
	

	@GetMapping("/retrieve-facture/{client-id}")
	@ResponseBody
	public Facture retrieveClient(@PathVariable("facture-id") Long factureId) {
	return factureService.retrieveFacture(factureId);
	}


	@PostMapping("/add-facture")
	@ResponseBody
	public Facture addClient(@RequestBody Facture f,@PathVariable("client-id") Long clientId)
	{
		Facture facture = factureService.addFacture(f,clientId);
	return facture;
	}

	@DeleteMapping("/cancel-facture/{facture-id}")
	@ResponseBody
	public void cancelFacture(@PathVariable("facture-id") Long factureId) {
		factureService.cancelFacture(factureId);
	}


	@PutMapping("/modify-client")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture) {
	return factureService.updateFacture(facture);
	}
}
