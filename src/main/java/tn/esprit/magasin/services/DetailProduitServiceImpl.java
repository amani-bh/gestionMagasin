package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.DetailProduit;
import tn.esprit.magasin.repositories.IDetailProduitRepository;

@Slf4j
@Service
public class DetailProduitServiceImpl implements IDetailProduitService{

	@Autowired
	IDetailProduitRepository repo;
	
	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		return repo.findAll();
	}

	@Override
	public DetailProduit addDetailProduit(DetailProduit dp) {
		return repo.save(dp);
	}

	@Override
	public void deleteDetailProduit(Long id) {
		repo.deleteById(id);
	}

	@Override
	public DetailProduit updateDetailFacture(DetailProduit dp) {
		return repo.save(dp);
	}

	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return repo.findById(id).orElse(null);
	}

}
