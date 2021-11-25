package tn.esprit.magasin.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.DetailProduit;
import tn.esprit.magasin.entities.Produit;
import tn.esprit.magasin.repositories.DetailProduitRepository;
import tn.esprit.magasin.repositories.ProduitRepository;
import tn.esprit.magasin.repositories.RayonRepository;
import tn.esprit.magasin.repositories.StockRepository;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

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
		// rayon r= rayonRepo.findById(idRayon).orElse(null);
		//stock s= stockRepo.findById(idStock).orElse(null);
		//p.setStock(s);
		//p.setRayon(r)
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).orElse(null);
	}

}
