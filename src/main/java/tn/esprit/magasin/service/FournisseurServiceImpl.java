package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Fournisseur;
import tn.esprit.magasin.repository.FournisseurRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepo;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepo.findAll();
		for (Fournisseur fournisseur : fournisseurs) {
			log.info("fournisseur:" + fournisseur);
		}
		return fournisseurs;
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		return fournisseurRepo.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepo.deleteById(id);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return fournisseurRepo.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return fournisseurRepo.findById(id).orElse(null);
	}

}
