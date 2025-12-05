package org.example.GestionONG.model;

import javax.persistence.*;

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
    private Long id;

    @Stereotype("DATE")
    private Date fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private TipoSangre tipo;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private FactorRH rh;

    @ManyToOne(optional = false)
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Persona persona;

    @ManyToMany
    @ListProperties("nombre")
    private List<Habilidad> habilidades;

    @OneToMany(mappedBy = "voluntario")
    private List<Participacion> participaciones;

    @ReadOnly
    public int calcularHorasTotales() {
        return participaciones == null ? 0 :
                participaciones.stream()
                        .mapToInt(Participacion::getHorasRegistradas)
                        .sum();
    }
}
