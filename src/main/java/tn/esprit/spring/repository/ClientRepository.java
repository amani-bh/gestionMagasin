package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.magasin.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
