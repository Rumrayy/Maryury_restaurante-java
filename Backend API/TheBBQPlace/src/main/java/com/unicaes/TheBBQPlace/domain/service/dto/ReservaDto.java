package com.unicaes.TheBBQPlace.domain.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.time.LocalTime;
@Getter
@Setter
public class ReservaDto {
    private String email;
    private String area;
    private Date date;
    private LocalTime hour;
    private Integer capacity;
}
