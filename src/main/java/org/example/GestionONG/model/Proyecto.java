package org.example.GestionONG.model;

import javax.persistence.*;

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
    @Required
    @MaxSize(20)
    private String codigoProyecto;

    @Required
    @Column(length = 150)
    @MaxSize(150)
    private String nombre;

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private TipoProyecto categoria;

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "persona.nombreCompleto")
    private Coordinador liderResponsable;

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio ubicacionEjecucion;

    @Required
    @Column(precision = 12, scale = 2)
    @Money
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal fondos;

    @OneToMany(mappedBy = "proyecto")
    @ListProperties("voluntario.persona.nombreCompleto, rolEnProyecto, fechaInicio, horasRegistradas")
    private List<Participacion> equipoTrabajo;

}

