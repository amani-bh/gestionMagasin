package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.DetailFacture;
import tn.esprit.magasin.repositories.DetailFactureRepository;

@Service
@Slf4j
public class DetailFactureServiceImpl implements IDetailFactureService {

	@Autowired
	DetailFactureRepository detailFactureRepo;

	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		List<DetailFacture> detailFactures = (List<DetailFacture>) detailFactureRepo.findAll();
	
		return detailFactures;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture df) {
		return detailFactureRepo.save(df);
	}

	@Override
	public void deleteDetailFacture(Long id) {
		detailFactureRepo.deleteById(id);
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture df) {
		return detailFactureRepo.save(df);
	}

	@Override
	public DetailFacture retrieveDetailFacture(Long id) {
		return detailFactureRepo.findById(id).orElse(null);
	}

}
