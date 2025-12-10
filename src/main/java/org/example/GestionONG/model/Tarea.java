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
    @MaxSize(200)                // No más de 200 caracteres
    @TextArea
    private String descripcion;

    @Required                    // No permitir null en boolean (opcional)
    private boolean completada;

    @Required
    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class)   // Pone la fecha actual por defecto
    @Future                      // Validar que sea una fecha futura
    private Date fechaLimite;

    @ManyToOne(optional = false)
    @Required
    private Participacion asignacion;
}

