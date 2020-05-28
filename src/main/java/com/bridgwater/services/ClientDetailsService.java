package com.bridgwater.services;

import com.bridgwater.models.ClientDetails;
import com.bridgwater.models.Clients;
import com.bridgwater.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientDetailsService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Clients> client = clientRepository.findByUsername(username);
        client.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return client.map(ClientDetails::new).get();
    }
}
