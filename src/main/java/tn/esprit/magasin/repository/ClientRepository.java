package tn.esprit.magasin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.magasin.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
