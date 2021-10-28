package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.repositories.IFactureRepository;

@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	IFactureRepository repo;

	@Override
	public List<Facture> retrieveAllFactures() {
		return repo.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f=repo.findById(id).orElse(null);
		f.setActive(false);
		repo.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return repo.findById(id).orElse(null);
	}

}
