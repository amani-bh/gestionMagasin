package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);

	Fournisseur retrieveFournisseur(Long id);
}
