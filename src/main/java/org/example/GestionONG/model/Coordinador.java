package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import java.math.BigDecimal;
import java.util.*;

@Getter
@Setter
@Entity
public class Coordinador {
    @Id
    @ReadOnly
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    @Column(length = 50)
    private String cargo;

    @Column(length = 100)
    private String areaDepartamento;

    @Column(length = 10)
    private String numeroExtension;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Persona persona;

    @OneToMany(mappedBy = "liderResponsable")
    @ListProperties("nombre, categoria.nombre, ubicacionEjecucion.nombre")
    private List<Proyecto> proyectosAprobados;

    @ReadOnly
    public void autorizarGasto(BigDecimal monto) {
        System.out.println("Gasto autorizado por " + persona.getNombreCompleto() +
                " por un monto de: " + monto);
    }
}
