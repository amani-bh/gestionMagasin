package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entities.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
}
