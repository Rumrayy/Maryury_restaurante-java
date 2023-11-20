package com.unicaes.TheBBQPlace.domain.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.time.LocalTime;
@Getter
@Setter
public class ReservaDto {
    private String name;
    private String area;
    private Date dateReserve;
    private LocalTime hourReserve;
    private Integer numberPersons;
}
