package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.persistence.crud.ClientCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSegurityService implements UserDetailsService {

    private final ClientCrudRepository clientCrudRepository;

    public UserSegurityService(ClientCrudRepository clientCrudRepository) {
        this.clientCrudRepository = clientCrudRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientEntity client = this.clientCrudRepository.findByEmail(email);

        if (client == null) {
            throw new UsernameNotFoundException("Client with email " + email + " not found.");
        }

        return User.builder()
                .username(client.getEmail())
                .password(client.getPassword())
                .roles(client.getRol())
                .build();
    }
}
