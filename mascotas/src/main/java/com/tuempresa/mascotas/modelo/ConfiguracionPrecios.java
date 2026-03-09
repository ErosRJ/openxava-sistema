package com.tuempresa.mascotas.modelo;


import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class ConfiguracionPrecios {

    @Id @Hidden
    private int id = 1; // Solo habrá un registro

    @Stereotype("MONEY")
    private double precioKiloPerro; // $50.00

    @Stereotype("MONEY")
    private double precioKiloGato; // $100.00
}