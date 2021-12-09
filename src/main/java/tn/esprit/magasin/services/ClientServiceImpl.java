package tn.esprit.magasin.services;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Profession;
import tn.esprit.magasin.repositories.IClientRepository;

@Slf4j
@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	IClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		return clientRepository.findAll();
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
	

	@Override
	public List<Client> retrieveClientsByProfession(Profession profession) {
		
		return clientRepository.findByProfession(profession);
	}

	@Override
	public Client getByUserName(String userName) {
		return clientRepository.findByUserName(userName);
	}


}
