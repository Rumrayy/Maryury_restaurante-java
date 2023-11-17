package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.persistence.crud.ClientCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public ClientEntity save(ClientEntity client) {
        if (client.getRol() == null || client.getRol().isEmpty()) {
            client.setRol("CUSTOMER");
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientCrudRepository.save(client);
    }
    public ClientEntity getId(int clientId) {
        return clientCrudRepository.findById(clientId);
    }
    public ClientEntity getprofile(String email){
        return clientCrudRepository.findByEmail(email);
    }

}
