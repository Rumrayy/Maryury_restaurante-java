package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.persistence.crud.TableCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableCrudRepository tableCrudRepository;

    public TableService(TableCrudRepository tableCrudRepository) {
        this.tableCrudRepository = tableCrudRepository;
    }

   /*public ResponseEntity<?> findAvailableTables(String area) {
       List<TableEntity> allTablesInArea = tableCrudRepository.findByArea(area);
       //List<TableEntity> availableTables = new ArrayList<>();

       /*for (TableEntity table : allTablesInArea) {
           if (table.getCapacity() >= capacity) {
               availableTables.add(table);
           }
       }
       if (allTablesInArea.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       return ResponseEntity.ok(allTablesInArea);
   }*/

}
