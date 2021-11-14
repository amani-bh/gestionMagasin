package tn.esprit.magasin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.magasin.entities.Client;
import tn.esprit.magasin.repositories.ClientRepository;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		List<Client>clients=(List<Client>) clientRepository.findAll();
	
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

}
