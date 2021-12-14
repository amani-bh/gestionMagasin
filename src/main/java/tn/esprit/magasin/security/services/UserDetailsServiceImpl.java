package tn.esprit.magasin.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.magasin.entity.Client;
import tn.esprit.magasin.repositories.IClientRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	IClientRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Client user = userRepository.findByUserName(username);

		return UserDetailsImpl.build(user);
	}

}
