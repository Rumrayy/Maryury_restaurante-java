package com.unicaes.TheBBQPlace.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer idCliente;

    private String nombres;

    private String apellidos;

    private String correo;

    @Column(name = "numero_telefono")
    private String telefono;

    @Column(name = "contraseña")
    private String contrasenia;
}
