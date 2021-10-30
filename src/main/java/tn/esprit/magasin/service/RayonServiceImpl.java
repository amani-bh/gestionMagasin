package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Rayon;
import tn.esprit.magasin.repository.RayonRepository;

@Service
@Slf4j
public class RayonServiceImpl implements RayonService {

	@Autowired
	RayonRepository rayonRepo;

	@Override
	public List<Rayon> retrieveAllRayons() {
		List<Rayon> rayons = (List<Rayon>) rayonRepo.findAll();
		for (Rayon rayon : rayons) {
			log.info("rayon:" + rayon);
		}
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

}
