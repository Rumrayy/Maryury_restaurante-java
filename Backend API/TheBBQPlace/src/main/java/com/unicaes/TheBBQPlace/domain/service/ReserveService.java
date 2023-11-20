package com.unicaes.TheBBQPlace.domain.service;

import com.unicaes.TheBBQPlace.domain.service.dto.ClientDto;
import com.unicaes.TheBBQPlace.domain.service.dto.ReservaDto;
import com.unicaes.TheBBQPlace.persistence.crud.ClientCrudRepository;
import com.unicaes.TheBBQPlace.persistence.crud.ReserveCrudRespository;
import com.unicaes.TheBBQPlace.persistence.crud.TableCrudRepository;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import com.unicaes.TheBBQPlace.persistence.entity.ReserveEntity;
import com.unicaes.TheBBQPlace.persistence.entity.TableEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {
    @Autowired
    private ReserveCrudRespository reserveCrudRespository;
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private TableCrudRepository tableCrudRepository;
    public ReserveEntity save(ReservaDto request, String email) {
        ClientEntity client = clientCrudRepository.findByEmail(email);
        List<TableEntity> availableTables = tableCrudRepository.findAvailableTables(
                request.getArea(),
                request.getCapacity(),
                request.getDate(),
                request.getHour()
        );

        if (availableTables.isEmpty()) {
            throw new EntityNotFoundException("Mesa no disponible para los criterios dados.");
        }

        // Asumiendo que quieres la primera mesa disponible
        TableEntity table = availableTables.get(0);
        ReserveEntity reserve = new ReserveEntity();
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(client.getClientId());
        clientDto.setName(client.getName());
        clientDto.setEmail(client.getEmail());
        //reserve.setClientDto(clientDto);

        reserve.setClient(client);
        reserve.setArea(request.getArea());
        reserve.setDate(request.getDate());
        reserve.setHour(request.getHour());
        reserve.setTable(table);

        reserve.setIdClient(client.getClientId());
        reserve.setTableId(table.getTableId());
        return ResponseEntity.ok(reserveCrudRespository.save(reserve)).getBody();
    }
    public ReserveEntity getId(int idClient) {
        return reserveCrudRespository.findById(idClient);
    }
}
