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
    @Required
    @MaxSize(20)
    private String cedula;

    @Required
    @Column(length = 100)
    @MaxSize(100)
    private String nombreCompleto;

    @Column(length = 20)
    @MaxSize(20)
    @Pattern(regexp = "^[0-9 +()-]*$",
            message = "El teléfono solo puede contener números y símbolos +()")
    private String telefono;

    @Column(length = 100)
    @MaxSize(100)
    @Email(message = "Formato de correo inválido")
    private String email;

    @Column(length = 200)
    @MaxSize(200)
    private String direccion;

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio municipioResidencia;
}
