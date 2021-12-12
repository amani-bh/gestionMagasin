package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;

public interface IDetailProduitService {
	
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit dp);

	void deleteDetailProduit(Long id);

	DetailProduit updateDetailProduit(DetailProduit dp);

	DetailProduit retrieveDetailProduit(Long id);
	
	List<Produit> ProduitByCategorieProduit(CategorieProduit categorieProduit);
}
