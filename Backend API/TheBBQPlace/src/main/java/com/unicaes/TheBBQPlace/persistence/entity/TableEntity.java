package com.unicaes.TheBBQPlace.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mesas")
@Getter
@Setter
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer tableId;

    @Column(name = "area")
    private String area;

    @Column(name = "numero_mesa")
    private Integer number;

    @Column(name = "capacidad")
    private Integer capacity;

}
