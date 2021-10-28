package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Produit;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
}
