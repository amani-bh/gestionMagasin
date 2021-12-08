package tn.esprit.magasin.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Dashboard;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.services.IDetailFactureService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detailFacture")
public class DetailFactureRestController {
	@Autowired
	IDetailFactureService dFactureService;
	
	@GetMapping("/retrieve-all-detailFactures")
	@ResponseBody
	public List<DetailFacture> getDetailFactures() {
	List<DetailFacture> listDFactures = dFactureService.retrieveAllDetailFactures();
	return listDFactures;
	}
	

	@GetMapping("/retrieve-detail-facture/{detailfacture-id}")
	@ResponseBody
	public DetailFacture retrieveDetailFacture(@PathVariable("detailfacture-id") Long detailfactureId) {
	return dFactureService.retrieveDetailFacture(detailfactureId);
	}


	@PostMapping("/add-detailfacture/{produit-id}/{facture-id}")
	@ResponseBody
	public DetailFacture addDetailFacture(@RequestBody DetailFacture df,@PathVariable("produit-id") Long produitId,@PathVariable("facture-id") Long factureId)
	{
		DetailFacture dFacture = dFactureService.addDetailFacture(df,produitId,factureId);
	    return dFacture;
	}

	@DeleteMapping("/delete-detailfacture/{detailfacture-id}")
	@ResponseBody
	public void deleteDetailFacture(@PathVariable("detailfacture-id") Long detailfactureId) {
		dFactureService.deleteDetailFacture(detailfactureId);
	}


	@PutMapping("/modify-detailFacture")
	@ResponseBody
	public DetailFacture modifyDetailFacture(@RequestBody DetailFacture df) {
	return dFactureService.updateDetailFacture(df);
	}
	
	@GetMapping("/dash-prix-date")
	@ResponseBody
	public List<Dashboard> dashPrixDate() {
	return dFactureService.dashPrixDate();
	}
	
	@GetMapping("/retrieve-dfacture-facture/{facture-id}")
	@ResponseBody
	public  List<DetailFacture> retrieveDetailFactureByFacture(@PathVariable("facture-id") Long factureId) {
	return dFactureService.retrieveDetailFactureByIdFacture(factureId);
	}
}
