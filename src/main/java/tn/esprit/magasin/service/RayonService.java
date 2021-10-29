package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Rayon;

public interface RayonService {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);
}