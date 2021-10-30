package tn.esprit.magasin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.repository.DetailFactureRepository;

@Service
@Slf4j
public class DetailFactureServiceImpl implements DetailFactureService {

	@Autowired
	DetailFactureRepository detailFactureRepo;

	@Override
	public List<DetailFacture> retrieveAllDetailFactures() {
		List<DetailFacture> detailFactures = (List<DetailFacture>) detailFactureRepo.findAll();
		for (DetailFacture detailFacture : detailFactures) {
			log.info("detailFacture:" + detailFacture);
		}
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
