package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Produit;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);
 
	Produit updateProduit(Produit p,Long idRayon, Long idStock);
	
	void deleteProduit(Long id);
	
	Produit retrieveProduit(Long id);
	
}
