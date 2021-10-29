package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Fournisseur;

public interface FournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);

	Fournisseur retrieveFournisseur(Long id);
}
