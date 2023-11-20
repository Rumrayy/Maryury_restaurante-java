package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.domain.service.dto.ReservaDto;
import com.unicaes.TheBBQPlace.persistence.crud.ReserveCrudRespository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import com.unicaes.TheBBQPlace.persistence.entity.ReserveEntity;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReserveService {
    @Autowired
    private ReserveCrudRespository reserveCrudRespository;
    private final TableService tableService;
    @Autowired
    public ReserveService(TableService tableService) {
        this.tableService = tableService;
    }
    public ResponseEntity<ReserveEntity> save(ReserveEntity reserve) {
        if (reserve.getArea() == "Restaurante" ) {
            if (reserve.getTableId() <= 2) reserve.setTableId(1);
            if (reserve.getTableId() > 3 && reserve.getTableId() < 4 ) reserve.setTableId(2);
            if (reserve.getTableId() > 5 && reserve.getTableId() < 6) reserve.setTableId(3);
            if (reserve.getTableId() <= 7) reserve.setTableId(4);
        }else if (reserve.getArea() == "Bar"){
            if (reserve.getTableId() < 2 && reserve.getTableId() > 0) reserve.setTableId(5);
            if (reserve.getTableId() > 2 && reserve.getTableId() < 5 ) reserve.setTableId(6);
            if (reserve.getTableId() > 7 && reserve.getTableId() < 4) reserve.setTableId(7);
            if (reserve.getTableId() >= 7) reserve.setTableId(8);
        }
        ReserveEntity savedReserve = reserveCrudRespository.save(reserve);
        return ResponseEntity.ok(savedReserve);
    }
    public ReserveEntity getId(int idClient) {
        return reserveCrudRespository.findById(idClient);
    }
}
