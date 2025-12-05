package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Participacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "persona.nombreCompleto")
    private Voluntario voluntario;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Proyecto proyecto;

    @Column(length = 50)
    private String rolEnProyecto;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    private int horasRegistradas;

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL)
    @ListProperties("descripcion, completada, fechaLimite")
    private List<Tarea> tareas;
}
