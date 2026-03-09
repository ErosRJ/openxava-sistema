package com.tuempresa.mascotas.modelo;


import javax.persistence.*;

import org.openxava.annotations.*;

import com.tuempresa.mascotas.modelo.Raza.*; // Para usar los enums

import lombok.*;

@Entity
@Getter @Setter
public class TablaConsumo {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TipoMascota tipo;

    @Enumerated(EnumType.STRING)
    private Tamano tamano;

    private double kilosSemana; // Ej: 1.0, 2.0, 4.0 según el PDF
}