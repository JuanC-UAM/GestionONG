package org.example.GestionONG.model;

import javax.persistence.*; // Regresamos a javax
import javax.validation.constraints.*; // Importante para @Size y @Min
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @Column(length = 20)
    // Usamos @Size de javax.validation en lugar de @MaxSize
    @Size(max = 20, message = "El código no puede tener más de 20 caracteres")
    @Required // Mantenemos @Required de OpenXava para la validación visual
    private String codigoProyecto;

    @Column(length = 150)
    @Required
    @Size(max = 150, message = "El nombre es muy largo")
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    @Required
    private TipoProyecto categoria;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "persona.nombreCompleto")
    @Required
    private Coordinador liderResponsable;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombre")
    @Required
    private Municipio ubicacionEjecucion;

    @Column(precision = 12, scale = 2)
    @Money
    @Required
    // @Min es compatible con javax y valida que sea 10,000 o más
    @Min(value = 10000, message = "El monto debe ser mayor o igual a 10,000")
    private BigDecimal fondos;

    @OneToMany(mappedBy = "proyecto")
    @ListProperties("voluntario.persona.nombreCompleto, rolEnProyecto, fechaInicio, horasRegistradas")
    private List<Participacion> equipoTrabajo;
}