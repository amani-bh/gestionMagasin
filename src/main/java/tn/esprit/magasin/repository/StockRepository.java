package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
