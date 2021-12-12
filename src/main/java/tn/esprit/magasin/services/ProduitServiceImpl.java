package tn.esprit.magasin.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.CategorieProduit;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.repositories.IDetailProduitRepository;
import tn.esprit.magasin.repositories.IProduitRepository;
import tn.esprit.magasin.repositories.IRayonRepository;
import tn.esprit.magasin.repositories.IStockRepository;

@Slf4j
@Service
public class ProduitServiceImpl implements IProduitService{
	@Autowired
	IProduitRepository repo;
	@Autowired
	IStockRepository stockRepo;
	@Autowired
	IRayonRepository rayonRepo;
	@Autowired
	IDetailProduitRepository detailRepo;
	

	@Override
	public List<Produit> retrieveAllProduits() {
		return repo.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		DetailProduit dp=new DetailProduit();
		dp.setDateCreation(new Date());
		dp.setCategorieProduit(CategorieProduit.Alimentaire);
		detailRepo.save(dp);
		p.setRayon(rayonRepo.findById(idRayon).orElse(null));
		p.setStock(stockRepo.findById(idStock).orElse(null));
		p.setDetailProduit(dp);
		return repo.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Produit updateProduit(Produit p, Long idRayon, Long idStock) {
		return repo.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		repo.deleteById(id);
		
	}

}
