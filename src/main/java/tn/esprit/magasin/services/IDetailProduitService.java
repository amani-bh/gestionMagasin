package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entities.DetailProduit;

public interface IDetailProduitService {
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit dp);

	void deleteDetailProduit(Long id);

	DetailProduit updateDetailFacture(DetailProduit dp);

	DetailProduit retrieveDetailProduit(Long id);
}
