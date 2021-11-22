package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Profession;


public interface IClientService {
	List<Client> retrieveAllClients();
	
	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
	
	@Query("SELECT c FROM Client c WHERE c.profession= :profession")
	List<Client> retrieveClientsByProfession(@Param("profession") Profession profession);

}
