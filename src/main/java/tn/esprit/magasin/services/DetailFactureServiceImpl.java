package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.repositories.IDetailFactureRepository;

@Service
public class DetailFactureServiceImpl implements IDetailFactureService {

	@Autowired
	IDetailFactureRepository repo;
	
	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		return repo.findAll();
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture df) {
		return repo.save(df);
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

}
