package com.tuempresa.mascotas.modelo;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter
public class TablaApoyo {

    @Id
    @Enumerated(EnumType.STRING)
    private EstadoPeso estado; // Peso Ideal, Bajo Peso...

    private int porcentaje; // 100, 70, 30, 0

    public enum EstadoPeso { PESO_IDEAL, BAJO_PESO, SOBREPESO, OBESO }
}