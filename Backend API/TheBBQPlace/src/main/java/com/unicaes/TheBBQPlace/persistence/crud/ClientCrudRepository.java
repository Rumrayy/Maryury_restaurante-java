package com.unicaes.TheBBQPlace.persistence.crud;

import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientCrudRepository extends CrudRepository<ClientEntity, Integer> {
    ClientEntity findById(int clientId);

    ClientEntity findByEmailAndPassword(String name, String password);

    ClientEntity findByEmail(String email);

}
