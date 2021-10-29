package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.DetailFacture;

public interface DetailFactureService {
	List<DetailFacture> retrieveAllDetailFactures();

	DetailFacture addDetailFacture(DetailFacture df);

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture df);

	DetailFacture retrieveDetailFacture(Long id);
}
