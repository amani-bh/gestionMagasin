package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.magasin.entity.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
