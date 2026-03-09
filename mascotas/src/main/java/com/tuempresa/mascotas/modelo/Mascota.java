package com.tuempresa.mascotas.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.jpa.*;

@Entity
public class Mascota {

    @Id @Hidden
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=30) @Required
    private String nombre;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    private Dueno dueno;

    @ManyToOne
    // @DescriptionsList(descriptionProperties="nombre") // Comentado para que salga la LUPA
    private Raza raza;

    @Required
    private double pesoActual;

    // --- CÁLCULOS ---

    @Transient
    @Depends("pesoActual, raza") // 
    public String getEstadoNutricional() {
        if (raza == null || pesoActual == 0) return "";
        
        if (pesoActual < raza.getPesoMinimoIdeal()) return "BAJO PESO";
        if (pesoActual >= raza.getPesoMinimoIdeal() && pesoActual <= raza.getPesoMaximoIdeal()) return "PESO IDEAL";
        
        double limiteSobrepeso = raza.getPesoMaximoIdeal() * 1.20; 
        if (pesoActual <= limiteSobrepeso) return "SOBREPESO";
        
        return "OBESO";
    }

    @Stereotype("MONEY")
    @Depends("pesoActual, raza") // 
    public BigDecimal getApoyoMensual() {
        // Usamos getEstadoNutricional() para no repetir lógica
        String estado = getEstadoNutricional();
        
        if (raza == null || estado.equals("")) return BigDecimal.ZERO;

        ConfiguracionPrecios config = XPersistence.getManager().find(ConfiguracionPrecios.class, 1);
        if (config == null) return BigDecimal.ZERO;
        
        double precioKilo = (raza.getTipo() == Raza.TipoMascota.PERRO) 
            ? config.getPrecioKiloPerro() 
            : config.getPrecioKiloGato();

        Query queryConsumo = XPersistence.getManager().createQuery(
            "from TablaConsumo t where t.tipo = :tipo and t.tamano = :tamano");
        queryConsumo.setParameter("tipo", raza.getTipo());
        queryConsumo.setParameter("tamano", raza.getTamano());
        
        try {
            TablaConsumo tablaConsumo = (TablaConsumo) queryConsumo.getSingleResult();
            double consumoSemanal = tablaConsumo.getKilosSemana();

            // Buscar Porcentaje
            int porcentajeInt = 0;
            
            if(estado.equals("PESO IDEAL")) porcentajeInt = 100;
            else if(estado.equals("BAJO PESO")) porcentajeInt = 70;
            else if(estado.equals("SOBREPESO")) porcentajeInt = 30;
            else porcentajeInt = 0;

            double total = (consumoSemanal * 4) * precioKilo * (porcentajeInt / 100.0);
            return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        } catch (Exception e) {
            return BigDecimal.ZERO; // 
        }
    }

    // --- GETTERS Y SETTERS MANUALES ---

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Dueno getDueno() { return dueno; }
    public void setDueno(Dueno dueno) { this.dueno = dueno; }

    // CORREGIDOS A 'raza'
    public Raza getRaza() { return raza; }
    public void setRaza(Raza raza) { this.raza = raza; }

    public double getPesoActual() { return pesoActual; }
    public void setPesoActual(double pesoActual) { this.pesoActual = pesoActual; }
}