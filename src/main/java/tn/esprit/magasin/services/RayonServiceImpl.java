package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.entity.Rayon;
import tn.esprit.magasin.repositories.IRayonRepository;

@Service
@Slf4j
public class RayonServiceImpl implements IRayonService {

	@Autowired
	IRayonRepository rayonRepo;

	@Override
	public List<Rayon> retrieveAllRayons() {
		List<Rayon> rayons = (List<Rayon>) rayonRepo.findAll();
		
		return rayons;
	}

	@Override
	public Rayon addRayon(Rayon r) {
		return rayonRepo.save(r);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonRepo.deleteById(id);
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		return rayonRepo.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return rayonRepo.findById(id).orElse(null);
	}

	@Override
	public Rayon RayonByProduit(Long idProduit) {
		return rayonRepo.RayonByProduit(idProduit);
	}

	@Override
	public List<Produit> RayonByIdProduit(Long idRayon) {
		return rayonRepo.RayonByIdProduit(idRayon);
	}

}
