package tn.esprit.magasin.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import tn.esprit.magasin.entity.Dashboard;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Produit;;

public interface IDetailFactureService {

	List<DetailFacture> retrieveAllDetailFactures();
	
	DetailFacture addDetailFacture(DetailFacture df,Long idProduit, Long idFacture);

	void deleteDetailFacture(Long id);

	DetailFacture updateDetailFacture(DetailFacture df, Long idF);

	DetailFacture retrieveDetailFacture(Long id);
	
	List<Dashboard> dashPrixDate();
	
	List<DetailFacture> retrieveDetailFactureByIdFacture(Long idF);
	
	List<DetailFacture> search(String keyword);
	
	List<?> bestProduct(Date startDate, Date endDate);
	
	List<?> getPrixDate();
}
