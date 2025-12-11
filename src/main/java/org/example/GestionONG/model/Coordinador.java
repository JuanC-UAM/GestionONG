package org.example.GestionONG.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@Entity
public class Coordinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required // Evita registrar un coordinador sin cargo
    @Column(length = 50)
    private String cargo;

    @Column(length = 100)
    private String areaDepartamento;

    @Column(length = 10)
    @Pattern(
            regexp = "^[0-9-]*$",
            message = "Solo números y guiones"
    ) // ''Controla que la extensión tenga formato válido''
    private String numeroExtension;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    @Required // ''Obliga a seleccionar una persona''
    private Persona persona;

    @OneToMany(mappedBy = "liderResponsable")
    @ListProperties("nombre, categoria.nombre, ubicacionEjecucion.nombre")
    private List<Proyecto> proyectosAprobados;

    //metodo solo//
}