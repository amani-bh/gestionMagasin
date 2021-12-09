package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Panier;

public interface  IPanierRepository extends JpaRepository<Panier, Long>{
Panier findByClient(Client c);
}
