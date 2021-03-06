package tn.esprit.magasin.services;

import java.util.Date;
import java.util.HashMap;
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


	@Override
	public DetailFacture updateDetailFacture(DetailFacture df, Long idF) {
		df.setFacture(repoFacture.getById(idF));
		return repo.save(df);
	}


	@Override
	public List<DetailFacture> search(String keyword) {
		if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
	}


	@Override
	public List<?> bestProduct(Date startDate, Date endDate) {
		return repo.bestProduct(startDate, endDate);
	}


	@Override
	public List<?> getPrixDate() {
		return repo.getPrixDate();
	}

}
