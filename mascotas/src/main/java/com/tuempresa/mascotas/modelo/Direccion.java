package com.tuempresa.mascotas.modelo; // <--- OJO: Asegúrate que esto coincida con tus otros archivos

import javax.persistence.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class Direccion {

    @Column(length=30)
    private String estado;
    
    @Column(length=30)
    private String ciudad;
    
    @Column(length=30)
    private String colonia;
    
    @Column(length=50)
    private String calle;
    
    private int numero;
    
    @Column(length=5)
    private String cp;
}