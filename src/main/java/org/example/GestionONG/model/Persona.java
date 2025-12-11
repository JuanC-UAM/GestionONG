package org.example.GestionONG.model;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Size(max = 20, message = "La cédula no puede superar los 20 caracteres")
    private String cedula;

    @Required
    @Column(length = 100)
    @Size(max = 100, message = "El nombre es muy largo")
    private String nombreCompleto;

    @Column(length = 20)
    @Size(max = 20, message = "El teléfono es muy largo")
    @Pattern(regexp = "^[0-9 +()-]*$",
            message = "El teléfono solo puede contener números y símbolos +()")
    private String telefono;

    @Column(length = 100)
    @Size(max = 100)
    @Email(message = "Formato de correo inválido")
    private String email;

    @Column(length = 200)
    @Size(max = 200)
    private String direccion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio municipioResidencia;
}