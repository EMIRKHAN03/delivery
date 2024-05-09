package com.example.delivery2.Security;

import com.example.delivery2.models.Client;
import com.example.delivery2.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientDetailsService implements UserDetailsService {
    ClientRepository clientRepository;
    @Autowired
    public ClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findByUsername(username);
        if(clientOptional.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }
        return new ClientDetails(clientOptional.get());

    }

}
