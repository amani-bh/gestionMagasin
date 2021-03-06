package tn.esprit.magasin.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entity.Panier;
import tn.esprit.magasin.entity.Produit;
import tn.esprit.magasin.repositories.IClientRepository;
import tn.esprit.magasin.repositories.IPanierRepository;
import tn.esprit.magasin.repositories.IProduitRepository;

@Slf4j
@Service
public class PanierServiceImpl implements IPanierService{

	@Autowired
	IPanierRepository repo;
	@Autowired
	IProduitRepository repoProduit;
	@Autowired
	IClientRepository repoClient;
	

	@Override
	public Panier add( Long idClient) {
		Panier p=new Panier();
		p.setClient(repoClient.findById(idClient).orElse(null));
		//p.getListProduit().add(repoProduit.getById(idProduit));
		p.setCreatedAt(new Date());
		return repo.save(p);
	}


	@Override
	public void deleteFromPanier(Long idPanier,Long idProduit) {
		Panier p=repo.findById(idPanier).orElse(null);
		//System.out.println(p.getListProduit().remove(repoProduit.findById(idProduit).orElse(null)));
		if(p.getListProduit().remove(repoProduit.findById(idProduit).orElse(null))){
			p.setNbr(p.getNbr()-1);
			p.setTotal(p.getTotal()-repoProduit.findById(idProduit).orElse(null).getPrixUnitaire());
			repo.save(p);
		}
		
	}


	@Override
	public Panier getPanierById(Long id) {
		return repo.findByClient(repoClient.findById(id).orElse(null));
	}


	@Override
	public void addProduitToPanier(Long idPanier, Long idProduit) {
		Panier p=repo.findById(idPanier).orElse(null);
		p.getListProduit().add(repoProduit.findById(idProduit).orElse(null));
		float t=0;
		for(int i=0;i<p.getListProduit().size();i++){
			t+=p.getListProduit().get(i).getPrixUnitaire();
		}
		p.setTotal(t);
		p.setNbr(p.getNbr()+1);
		repo.save(p);
		
	}

}
