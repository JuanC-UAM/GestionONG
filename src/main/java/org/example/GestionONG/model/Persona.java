package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    @Column(length = 20)
    private String cedula;

    @Required
    @Column(length = 100)
    private String nombreCompleto;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;

    @Column(length = 200)
    private String direccion;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio municipioResidencia;
}
