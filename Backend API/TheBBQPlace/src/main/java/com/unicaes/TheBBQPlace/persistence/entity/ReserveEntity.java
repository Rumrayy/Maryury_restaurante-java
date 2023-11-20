package com.unicaes.TheBBQPlace.persistence.entity;

import com.unicaes.TheBBQPlace.domain.service.dto.ClientDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.time.LocalTime;

@Entity
@Table(name = "reservacion")
@Getter
@Setter
public class ReserveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Integer reserveId;

    @Column(name = "id_cliente")
    private Integer idClient;

    @Column(name = "area")
    private String area;

    @Column(name = "fecha_reservacion")
    private Date date;

    @Column(name = "hora_reserva")
    private LocalTime hour;

    @Column(name = "id_mesa")
    private Integer tableId;

    @Column(name = "id_pago")
    private Integer idPayment;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "cliente_id", insertable = false, updatable = false)
    private ClientEntity client;

    @OneToOne
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa", insertable = false, updatable = false)
    private TableEntity table;


    public void setClientDto(ClientDto clientDto) {
    }
}
