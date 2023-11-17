package com.unicaes.TheBBQPlace.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer clientId;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellidos")
    private String lastname;

    @Column(name = "correo")
    private String email;

    @Column(name = "numero_telefono")
    private String cellphone;

    @Column(name = "contrasena")
    private String password;

    @Column(name = "rol")
    private String rol;
}
