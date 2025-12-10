package org.example.GestionONG.model;

import javax.persistence.*; // JPA estándar (evita el error de jakarta)
import javax.validation.constraints.*; // Necesario para @Size, @Pattern, @Email
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*; // Anotaciones visuales de OpenXava

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @Column(length = 20)
    @Required
    @Size(max = 20, message = "La cédula es muy larga") // Reemplazo de @MaxSize
    private String cedula;

    @Required
    @Column(length = 100)
    @Size(max = 100, message = "El nombre es muy largo") // Reemplazo de @MaxSize
    private String nombreCompleto;

    @Column(length = 20)
    @Size(max = 20, message = "El teléfono es muy largo") // Reemplazo de @MaxSize
    @Pattern(regexp = "^[0-9 +()-]*$", message = "El teléfono solo puede contener números y símbolos +()")
    private String telefono;

    @Column(length = 100)
    @Size(max = 100, message = "El email es muy largo") // Reemplazo de @MaxSize
    @Email(message = "Formato de correo inválido") // Requiere javax.validation.constraints
    private String email;

    @Column(length = 200)
    @Size(max = 200, message = "La dirección es muy larga") // Reemplazo de @MaxSize
    private String direccion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio municipioResidencia;
}