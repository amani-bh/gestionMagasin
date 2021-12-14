package tn.esprit.magasin.services;

import java.util.List;

import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.entity.Rayon;

public interface IRayonService {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);
	
	Rayon RayonByProduit(Long idProduit);
	
	List<Produit> RayonByIdProduit(Long idRayon);
}