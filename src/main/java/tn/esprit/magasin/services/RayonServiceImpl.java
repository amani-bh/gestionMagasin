package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Rayon;
import tn.esprit.magasin.entity.Stock;
import tn.esprit.magasin.repositories.IRayonRepository;

@Slf4j
@Service
public class RayonServiceImpl implements IRayonService{
	
	@Autowired
	IRayonRepository repo;

	@Override
	public List<Rayon> retrieveAllRayons() {
		return repo.findAll();
	}

	@Override
	public Rayon addRayon(Rayon r) {
		return repo.save(r);
	}

	@Override
	public void deleteRayon(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		return repo.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		return repo.findById(id).orElse(null);
	}

	

}
