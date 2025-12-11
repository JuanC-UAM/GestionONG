package org.example.GestionONG.model;

import javax.persistence.*;
import javax.validation.constraints.*; // <--- IMPORTANTE para @Past
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Voluntario {

    public enum TipoSangre { A, B, AB, O }
    public enum FactorRH { NULL, POSITIVO, NEGATIVO }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private Long id;

    @Required
    @Stereotype("DATE")
    @Past(message = "La fecha de nacimiento debe ser pasada")
    private Date fechaNacimiento;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private TipoSangre tipo;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private FactorRH rh;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @Required
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Persona persona;

    @ManyToMany(fetch = FetchType.LAZY)
    @ListProperties("nombre, descripcion")
    private Collection<Habilidad> habilidades;

    @OneToMany(mappedBy = "voluntario")
    @ListProperties("proyecto.nombre, rolEnProyecto, fechaInicio, horasRegistradas")
    private Collection<Participacion> participaciones;

    @ReadOnly
    public int calcularHorasTotales() {
        return participaciones == null ? 0 :
                participaciones.stream()
                        .mapToInt(Participacion::getHorasRegistradas)
                        .sum();
    }
}