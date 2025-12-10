package org.example.GestionONG.model;

import javax.persistence.*; // JPA Estándar
import javax.validation.constraints.*; // Necesario para @Size y @Future
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator; // Importante para el calculador
import java.util.*;

@Getter
@Setter
@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    @Required
    @Size(max = 200, message = "La descripción no puede superar los 200 caracteres") // Reemplazo de @MaxSize
    @Stereotype("MEMO") // Reemplazo estándar de OpenXava para @TextArea
    private String descripcion;

    @Required
    private boolean completada;

    @Required
    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class) // Requiere el import de org.openxava.calculators
    @Future(message = "La fecha límite debe ser una fecha futura") // Requiere javax.validation.constraints
    private Date fechaLimite;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Required
    @DescriptionsList // Muestra una lista desplegable en lugar de una lupa
    private Participacion asignacion;
}