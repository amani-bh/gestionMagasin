package tn.esprit.magasin.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.DetailFacture;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.repositories.IClientRepository;
import tn.esprit.magasin.repositories.IDetailFactureRepository;
import tn.esprit.magasin.repositories.IFactureRepository;
import tn.esprit.magasin.repositories.IProduitRepository;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	IFactureRepository repo;
	@Autowired
	IClientRepository repoClient;
	@Autowired
	IDetailFactureRepository repoDetailFacture;
	@Autowired
	IProduitRepository repoProduit;

	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> list=repo.findAll();
		return repo.findAll();
	}

	@Override
	public void cancelFacture(Long id) {
		Facture f=repo.findById(id).orElse(null);
		f.setActive(false);
		repo.save(f);
	}

	@Override
	public Facture retrieveFacture(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Facture addDetailsFacture(Facture f,List<DetailFacture>detailsFacture){
		float montantRemise=0;
		float montantFacture=0;
		for(DetailFacture detail:detailsFacture){
			Produit produit=repoProduit.getById(detail.getProduit().getIdProduit());
			float prixTotalDetail=detail.getQte()*produit.getPrixUnitaire();
			float montantRemiseDetail=(prixTotalDetail*detail.getPourcentageRemise())/100;
			float prixTotalDetailRemise=prixTotalDetail-montantRemiseDetail;
			detail.setMontantRemise(montantRemiseDetail);
			detail.setPrixTotal(prixTotalDetailRemise);
			montantFacture+=prixTotalDetailRemise;
			montantRemise+=montantRemiseDetail;
			detail.setProduit(produit);
			detail.setFacture(f);
			detail.setCreatedAt(new Date());
			repoDetailFacture.save(detail);
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		return f;
	}
	
	@Transactional
	public Facture addFacture(Long idFacture, Long idClient) {
		Facture f=repo.getById(idFacture);
		f.setClient(repoClient.getById(idClient));
		f.setDateFacture(new Date());
		f.setActive(true);
		f.setCreatedAt(new Date());
		List<DetailFacture> detailsFacture=(List<DetailFacture>) f.getDetailFactures();
		Facture facture=addDetailsFacture(f,detailsFacture);
		return repo.save(facture);
	}

	@Override
	public Facture updateFacture(Facture f) {
		return repo.save(f);
	}


	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		return repo.FacturesByClient(idClient);
	}
	
	@Override
	public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
			Date startDate, Date endDate) {
				return repo.calculer(categorieClient, startDate, endDate);
		
	}
	
	public Facture add(Facture f, Long idClient){
		f.setClient(repoClient.getById(idClient));
		f.setDateFacture(new Date());
		f.setActive(true);
		return repo.save(f);
	}

}
