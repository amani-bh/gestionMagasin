package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.DetailProduit;
import tn.esprit.magasin.repositories.DetailProduitRepository;

@Service
@Slf4j
public class DetailProduitServiceImpl implements IDetailProduitService {

	@Autowired
	DetailProduitRepository detailProduitRepo;

	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		List<DetailProduit> detailProduits = (List<DetailProduit>) detailProduitRepo.findAll();
	
		return detailProduits;
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
