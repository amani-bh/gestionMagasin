package tn.esprit.magasin.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.services.IFactureService;
import tn.spring.magasin.utils.GeneratePdf;

@CrossOrigin(origins = "http://localhost:4200")
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
	

	@GetMapping("/retrieve-facture/{facture-id}")
	@ResponseBody
	public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
	return factureService.retrieveFacture(factureId);
	}


	@PostMapping("/add-facture/{client-id}/{facture-id}")
	@ResponseBody
	public Facture addFacture(@PathVariable("facture-id") Long f,@PathVariable("client-id") Long clientId)
	{
		Facture facture = factureService.addFacture(f,clientId);
	return facture;
	}

	@DeleteMapping("/cancel-facture/{facture-id}")
	@ResponseBody
	public void cancelFacture(@PathVariable("facture-id") Long factureId) {
		factureService.cancelFacture(factureId);
	}


	@PutMapping("/modify-Facture")
	@ResponseBody
	public Facture modifyFacture(@RequestBody Facture facture) {
	return factureService.updateFacture(facture);
	}
	
	@GetMapping("/retrieve-factures-client/{client-id}")
	@ResponseBody
	public List<Facture> getFacturesByClient(@PathVariable("client-id") Long clientId) {
	return factureService.getFacturesByClient(clientId);
	}
	
	@GetMapping("/chiffre-affaire-facture/{client-categorie}/{start-date}/{end-date}")
	@ResponseBody
	public float ChiffreAffaireParCategorieClient(@PathVariable("client-categorie") CategorieClient categorieClient,@PathVariable("start-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,@PathVariable("end-date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
	return  factureService.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
	}
	
	@GetMapping("/report/{client-id}")
	@ResponseBody
	public ResponseEntity<InputStreamResource> Report(@PathVariable("client-id") long clientId ) throws IOException {
        List<Facture> list = (List<Facture>) factureService.getFacturesByClient(clientId);

        ByteArrayInputStream bis = GeneratePdf.Report(list);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=factures.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
