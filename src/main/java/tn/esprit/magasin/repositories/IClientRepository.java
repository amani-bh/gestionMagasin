package tn.esprit.magasin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
