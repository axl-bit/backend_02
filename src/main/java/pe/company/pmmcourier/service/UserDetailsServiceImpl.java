package pe.company.pmmcourier.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.company.pmmcourier.model.Colaborador;
import pe.company.pmmcourier.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Colaborador user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not found with username: " + username));
		
		return UserDetailsImpl.build(user);
	}

}
