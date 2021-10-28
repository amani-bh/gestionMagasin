package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long>{

}
