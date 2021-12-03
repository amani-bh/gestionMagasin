package tn.esprit.magasin.services;

import tn.esprit.magasin.entity.Panier;
import tn.esprit.magasin.entity.Produit;

public interface IPanierService {
	Panier add(Long idClient);
	void deleteFromPanier(Long idPanier,Long idProduit);
	Panier getPanierById(Long id);
	void addProduitToPanier(Long idPanier,Long idProduit);

}
