package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.DetailProduit;

public interface DetailProduitService {
	List<DetailProduit> retrieveAllDetailProduits();

	DetailProduit addDetailProduit(DetailProduit dp);

	void deleteDetailProduit(Long id);

	DetailProduit updateDetailFacture(DetailProduit dp);

	DetailProduit retrieveDetailProduit(Long id);
}
