package tn.esprit.magasin.services;

import java.util.List;
import java.util.Set;

import tn.esprit.magasin.entity.Dashboard;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.entity.Facture;;

public interface IDetailFactureService {

	List<DetailFacture> retrieveAllDetailFactures();
	
	DetailFacture addDetailFacture(DetailFacture df,Long idProduit, Long idFacture);

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture df);

	DetailFacture retrieveDetailFacture(Long id);
	
	List<Dashboard> dashPrixDate();
	
	List<DetailFacture> retrieveDetailFactureByIdFacture(Long idF);
}
