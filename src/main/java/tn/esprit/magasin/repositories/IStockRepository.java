package tn.esprit.magasin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {
	Stock findByLibelleStock(String libelleStock);

}
