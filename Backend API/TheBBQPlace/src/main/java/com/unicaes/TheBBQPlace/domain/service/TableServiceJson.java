package com.unicaes.TheBBQPlace.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicaes.TheBBQPlace.persistence.entity.FrontDataArea;

import java.io.IOException;

public class TableServiceJson {

    public void tableJson(String jsonInput) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FrontDataArea frontDataArea = objectMapper.readValue(jsonInput, FrontDataArea.class);

        System.out.println("Área: " + frontDataArea.getArea());
        System.out.println("Capacidad: " + frontDataArea.getCapacity());
        System.out.println("Hora: " + frontDataArea.getHour());
    }
}
