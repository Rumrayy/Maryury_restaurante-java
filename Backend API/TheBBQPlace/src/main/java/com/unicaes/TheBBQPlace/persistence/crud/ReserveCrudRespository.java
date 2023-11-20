package com.unicaes.TheBBQPlace.persistence.crud;

import com.unicaes.TheBBQPlace.persistence.entity.ReserveEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReserveCrudRespository extends CrudRepository<ReserveEntity,Integer> {

    ReserveEntity findById(int idClient);
}
