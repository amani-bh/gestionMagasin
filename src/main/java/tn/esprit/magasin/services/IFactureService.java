package tn.esprit.magasin.services;

import java.util.Date;
import java.util.List;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Fournisseur;

public interface IFactureService {
	
	List<Facture> retrieveAllFactures();
	
	void cancelFacture(Long id);
	
	Facture retrieveFacture(Long id);
	
	Facture addFacture(Long idFacture, Long idClient);
	
	Facture updateFacture(Facture f);
	
	List<Facture> getFacturesByClient(Long idClient);
	
	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
			Date startDate, Date endDate);
	public Facture add( Long idClient);
}
