package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Facture;

public interface FactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
}
