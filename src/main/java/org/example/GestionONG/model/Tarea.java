package org.example.GestionONG.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

// --- IMPORTACIONES AÑADIDAS ---
import org.openxava.calculators.*; // Para CurrentDateCalculator
import javax.validation.constraints.*; // Para @Future y @Size

@Getter
@Setter
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private Long id;

    @Required
    @Column(length = 200)
    @Size(max = 200, message = "La descripción no puede superar los 200 caracteres")
    @TextArea
    private String descripcion;

    @Required
    private boolean completada;

    @Required
    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    @Future(message = "La fecha límite debe ser futura")
    private Date fechaLimite;

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "proyecto.nombre, rolEnProyecto")
    private Participacion asignacion;
}