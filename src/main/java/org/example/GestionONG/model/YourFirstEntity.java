package org.example.GestionONG.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*; // JPA Estándar
import javax.validation.constraints.*; // Necesario para @Size

import lombok.Getter;
import lombok.Setter;

import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator; // Calculador para LocalDate
import org.openxava.model.Identifiable; // Clase base de OpenXava (provee el ID)

@Entity
@Getter
@Setter
public class YourFirstEntity extends Identifiable {

    @Column(length = 50)
    @Required
    @Size(max = 50, message = "La descripción es muy larga") // Reemplazo de @MaxSize
    private String description;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Línea completada
    private LocalDate date; // Campo que faltaba

    // He añadido este campo porque tenías el import de BigDecimal arriba
    @Column(precision = 10, scale = 2)
    @Money
    private BigDecimal amount;
}