package tn.esprit.magasin.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Profession;

public interface IClientRepository extends JpaRepository<Client, Long>{

	List<Client> findByProfession(Profession profession);
	List<Client> findByCategorieClient(CategorieClient categorieClient);
	Client findByUserName(String userName);
	boolean existsByUserName(String username);
	boolean existsByEmail(String email);
	
}
