package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.repository.DetailProduitRepository;

public class DetailProduitServiceImpl implements DetailProduitService {
	
	@Autowired
	DetailProduitRepository detailProduitRepo;

	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		return detailProduitRepo.findAll();
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit dp) {
		return detailProduitRepo.save(dp);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		detailProduitRepo.deleteById(id);
	}

	@Override
	public DetailProduit updateDetailFacture(DetailProduit dp) {
		return detailProduitRepo.save(dp);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return detailProduitRepo.findById(id).orElse(null);
	}

}
