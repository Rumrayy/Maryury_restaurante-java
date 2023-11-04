package com.unicaes.TheBBQPlace.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.time.LocalTime;

@Entity
@Table(name = "reservaciones")
@Getter
@Setter
public class ReserveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservacion_id")
    private Integer reserveId;

    @Column(name = "cliente_id")
    private Integer clientId;

    @Column(name = "fecha_reserva")
    private Date date;

    @Column(name = "hora_reserva")
    private LocalTime hour;

    @Column(name = "mesa_id")
    private Integer tableId;

    @Column(name = "pago_token")
    private String token;

    @Column(name = "transaccion_id")
    private String transactionId;

    @Column(name = "estado_pago")
    private String active;

}
