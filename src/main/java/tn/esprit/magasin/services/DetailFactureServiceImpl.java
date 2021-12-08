package tn.esprit.magasin.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Dashboard;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.repositories.IDetailFactureRepository;
import tn.esprit.magasin.repositories.IFactureRepository;
import tn.esprit.magasin.repositories.IProduitRepository;

@Slf4j
@Service
public class DetailFactureServiceImpl implements IDetailFactureService {

	@Autowired
	IDetailFactureRepository repo;
	@Autowired
	IFactureRepository repoFacture;
	@Autowired
	IProduitRepository repoProduit;
	
	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		return repo.findAll();
	}


	@Override
	public void deleteDetailFacture(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture df) {
		return repo.save(df);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		return repo.findById(id).orElse(null);
	}


	@Override
	public DetailFacture addDetailFacture(DetailFacture df, Long idProduit, Long idFacture) {
		df.setProduit(repoProduit.getById(idProduit));
		df.setFacture(repoFacture.getById(idFacture));
		return repo.save(df);
	}
	
	public List<Dashboard> dashPrixDate(){
		return repo.dashPrixDate();
	}


	@Override
	public List<DetailFacture> retrieveDetailFactureByIdFacture(Long idF) {
		return repo.findByFacture(repoFacture.findById(idF).orElse(null));
	}

}
