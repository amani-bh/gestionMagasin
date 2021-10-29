package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.magasin.entity.Fournisseur;
import tn.esprit.magasin.repository.FournisseurRepository;

public class FournisseurServiceImpl implements FournisseurService {
	
	@Autowired
	FournisseurRepository fournisseurRepo;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return fournisseurRepo.findAll();
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
