package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
