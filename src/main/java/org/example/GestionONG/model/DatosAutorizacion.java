package org.example.GestionONG.model;

import java.math.*;
import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Getter @Setter
public class DatosAutorizacion {

    @Required(message="El monto es obligatorio")
    @Min(value = 1, message = "El monto debe ser positivo")
    private BigDecimal monto;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @DescriptionsList(descriptionProperties="nombre")
    @Required(message="Seleccionar un proyecto")
    private Proyecto proyecto;

}