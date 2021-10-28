package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.DetailFacture;


public interface IDetailFactureRepository extends JpaRepository<DetailFacture, Long>{

}
