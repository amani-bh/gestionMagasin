package tn.esprit.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.magasin.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
