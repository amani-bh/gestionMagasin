package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
