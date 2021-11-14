package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.Fournisseur;
import tn.esprit.magasin.repositories.FournisseurRepository;

@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepo;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepo.findAll();
		
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
