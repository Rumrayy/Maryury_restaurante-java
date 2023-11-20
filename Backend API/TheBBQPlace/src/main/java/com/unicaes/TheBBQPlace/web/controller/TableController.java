package com.unicaes.TheBBQPlace.web.controller;

import com.unicaes.TheBBQPlace.domain.service.TableService;
import com.unicaes.TheBBQPlace.persistence.entity.FrontDataArea;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("/find")
    public ResponseEntity<?> find(@RequestBody String area){
        //return tableService.findAvailableTables(frontDataArea);
        //return "Datos recibidos: " + frontDataArea.getArea() + ", Capacidad: " + frontDataArea.getCapacity() + ", Hora: " + frontDataArea.getHour();
        return tableService.findAvailableTables(area);
    }
}
