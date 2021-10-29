package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Produit;

public interface ProduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
}
