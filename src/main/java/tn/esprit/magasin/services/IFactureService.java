package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Facture;

public interface IFactureService {
	
	List<Facture> retrieveAllFactures();
	
	void cancelFacture(Long id);
	
	Facture retrieveFacture(Long id);
	
	Facture addFacture(Facture f, Long idClient);
	
	Facture updateFacture(Facture f);
	
	List<Facture> getFacturesByClient(Long idClient);

}
