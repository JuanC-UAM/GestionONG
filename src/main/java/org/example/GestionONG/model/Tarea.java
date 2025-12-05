package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    @Column(length = 200)
    private String descripcion;

    private boolean completada;

    @Temporal(TemporalType.DATE)
    private Date fechaLimite;

    @ManyToOne(optional = false)
    private Participacion asignacion;
}
