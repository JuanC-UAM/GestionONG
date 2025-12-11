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
    @ReadOnly
    private Long id;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "persona.nombreCompleto")
    @Required // ''Obliga a seleccionar el voluntario que participa''
    private Voluntario voluntario;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombre")
    @Required // ''Evita registrar participación sin un proyecto asignado''
    private Proyecto proyecto;

    @Column(length = 50)
    private String rolEnProyecto; // ''Rol opcional, solo limitado por longitud''

    @Temporal(TemporalType.DATE)
    private Date fechaInicio; // ''Fecha opcional''

    private int horasRegistradas; // ''Solo número entero, sin validaciones extra''

    @OneToMany(mappedBy = "asignacion", cascade = CascadeType.ALL)
    @ListProperties("descripcion, completada, fechaLimite")
    private List<Tarea> tareas; // ''Lista administrada por el proyecto''
}
