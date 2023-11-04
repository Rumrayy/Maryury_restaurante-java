package com.unicaes.TheBBQPlace.persistence;

import com.unicaes.TheBBQPlace.persistence.crud.ClientCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public ClientEntity save(ClientEntity client) {
        return clientCrudRepository.save(client);
    }

    public ClientEntity getId(int clientId){
        return clientCrudRepository.findById(clientId);
    }

    public ClientEntity bu(String name, String password){
        return clientCrudRepository.findByEmailAndPassword(name, password);
    }

    public ClientEntity login(String email){
        return clientCrudRepository.findByEmail(email);
    }

}
