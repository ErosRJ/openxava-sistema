package com.tuempresa.mascotas.modelo;


import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Dueno {

    @Id
    @Column(length=10)
    private String telefono; // Identificador simple

    @Column(length=50) @Required
    private String nombre;

    private int edad;

    @Column(length=50) @Stereotype("EMAIL")
    private String correoElectronico;

    @Embedded
    private Direccion direccion; // Clase Direccion igual a la respuesta anterior
}