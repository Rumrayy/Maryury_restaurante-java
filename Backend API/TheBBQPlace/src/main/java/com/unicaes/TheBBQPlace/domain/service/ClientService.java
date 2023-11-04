package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.persistence.crud.ClientCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public ClientEntity save(ClientEntity client) {
        if (client.getRol() == null || client.getRol().isEmpty()) {
            client.setRol("CUSTOMER");
        }return clientCrudRepository.save(client);
    }

    public ClientEntity getId(int clientId) {
        return clientCrudRepository.findById(clientId);
    }

    public ClientEntity login(String email){
        return clientCrudRepository.findByEmail(email);
    }

    public ClientEntity login(String name, String password){
        return clientCrudRepository.findByEmailAndPassword(name, password);
    }
}
