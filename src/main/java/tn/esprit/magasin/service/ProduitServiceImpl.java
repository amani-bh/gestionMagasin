package tn.esprit.magasin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.repository.DetailProduitRepository;
import tn.esprit.magasin.repository.ProduitRepository;
import tn.esprit.magasin.repository.RayonRepository;
import tn.esprit.magasin.repository.StockRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepo;
	@Autowired
	RayonRepository rayonRepo;
	@Autowired
	DetailProduitRepository detailRepo;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {
			log.info("produit:" + produit);
		}
		return produits;
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		DetailProduit dp = new DetailProduit();
		Date d = new Date();
		dp.setDateCreation(d);
		// dp.setCategorieProduit(CategorieProduit.Alimentaire);
		detailRepo.save(dp);
		p.setRayon(rayonRepo.findById(idRayon).orElse(null));
		p.setStock(stockRepo.findById(idStock).orElse(null));
		p.setDetailProduit(dp);
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).orElse(null);
	}

}
