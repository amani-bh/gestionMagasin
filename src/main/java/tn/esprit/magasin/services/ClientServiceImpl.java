package tn.esprit.magasin.services;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.magasin.entity.CategorieClient;
import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.entity.Facture;
import tn.esprit.magasin.entity.Profession;
import tn.esprit.magasin.repositories.IClientRepository;

@Slf4j
@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	IClientRepository clientRepository;
	@Autowired
	IClientService ics;
	@Override
	public List<Client> retrieveAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Client addClient(Client c) {
c.setPassword(encoder.encode(c.getPassword()));
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

	@Override
	public Long retrieveNbrClients() {
		
		return clientRepository.count();
	}

	@Override
	public List<Client> retrieveClientsFidele(CategorieClient categorieClient) {
		
		return clientRepository.findByCategorieClient(categorieClient);
	}

	@Override
	public Client resetPassword(Long idClient, String password) 
	{
		Client cli;
				cli=clientRepository.getById(idClient);
		System.out.println(cli.toString());
		cli.setPassword(password);
		
		return clientRepository.save(cli);
	}


}
