package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.Facture;
import tn.esprit.magasin.repositories.FactureRepository;

@Service
@Slf4j
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
	
		return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f = factureRepository.findById(id).orElse(null);
		f.setActive(false);
		factureRepository.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return factureRepository.findById(id).orElse(null);
	}

}
