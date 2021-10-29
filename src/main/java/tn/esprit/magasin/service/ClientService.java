package tn.esprit.magasin.service;

import java.util.List;

import tn.esprit.magasin.entity.Client;

public interface ClientService {
	List<Client> retrieveAllClients(List<Client> c);

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);
}
