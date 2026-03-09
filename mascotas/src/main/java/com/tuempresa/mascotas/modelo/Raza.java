package com.tuempresa.mascotas.modelo;
import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Raza {

    @Id
    @Column(length=50)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Required
    private TipoMascota tipo;

    @Enumerated(EnumType.STRING)
    @Required
    private Tamano tamano;

    private double pesoMinimoIdeal;
    private double pesoMaximoIdeal;

    public enum TipoMascota { PERRO, GATO }
    public enum Tamano { MINI, PEQUENO, MEDIANO, GRANDE, MUY_GRANDE }

    // GETTERS Y SETTERS MANUALES
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public TipoMascota getTipo() { return tipo; }
    public void setTipo(TipoMascota tipo) { this.tipo = tipo; }
    
    public Tamano getTamano() { return tamano; }
    public void setTamano(Tamano tamano) { this.tamano = tamano; }
    
    public double getPesoMinimoIdeal() { return pesoMinimoIdeal; }
    public void setPesoMinimoIdeal(double pesoMinimoIdeal) { this.pesoMinimoIdeal = pesoMinimoIdeal; }
    
    public double getPesoMaximoIdeal() { return pesoMaximoIdeal; }
    public void setPesoMaximoIdeal(double pesoMaximoIdeal) { this.pesoMaximoIdeal = pesoMaximoIdeal; }
}