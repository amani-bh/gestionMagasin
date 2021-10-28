package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Stock;

public interface IStockRepository extends JpaRepository<Stock, Long>{

}
