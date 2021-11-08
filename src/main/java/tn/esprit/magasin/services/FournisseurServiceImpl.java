package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Fournisseur;
import tn.esprit.magasin.repositories.IFournisseurRepository;

@Slf4j
@Service
public class FournisseurServiceImpl implements IFournisseurService{
	
	@Autowired
	IFournisseurRepository repo;
	

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		return repo.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		return repo.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return repo.save(f);
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		return repo.findById(id).orElse(null);
	}

}
