package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.repository.FactureRepository;

public class FactureServiceImpl implements FactureService {
	
	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		return factureRepository.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f=factureRepository.findById(id).orElse(null);
		f.setActive(false);
		factureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return factureRepository.findById(id).orElse(null);
	}

}
