package tn.esprit.magasin.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.repositories.IClientRepository;
import tn.esprit.magasin.repositories.IFactureRepository;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	IFactureRepository repo;
	@Autowired
	IClientRepository repoClient;


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

	
	public Facture addFacture(Facture f, Long idClient) {
		f.setClient(repoClient.getById(idClient));;
		return repo.save(f);
	}

	@Override
	public Facture updateFacture(Facture f) {
		return repo.save(f);
	}


	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		return repo.FacturesByClient(idClient);
	}
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
			Date startDate, Date endDate) {
				return repo.calculer(categorieClient, startDate, endDate);
		
	}

	@Override
	public Facture addFacture(Long idFacture, Long idClient) {
		// TODO Auto-generated method stub
		return null;
	}

}