package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.repository.DetailProduitRepository;

@Service
@Slf4j
public class DetailProduitServiceImpl implements DetailProduitService {

	@Autowired
	DetailProduitRepository detailProduitRepo;

	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		List<DetailProduit> detailProduits = (List<DetailProduit>) detailProduitRepo.findAll();
		for (DetailProduit detailProduit : detailProduits) {
			log.info("detailProduit:" + detailProduit);
		}
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
