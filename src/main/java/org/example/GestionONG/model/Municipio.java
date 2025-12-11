package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private Long id;

    @Required
    @Column(length = 50)
    private String nombre;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Departamento departamento;

    @OneToMany(mappedBy = "ubicacionEjecucion")
    @ListProperties("codigoProyecto, nombre, categoria.nombre")
    private List<Proyecto> proyectos;
}
