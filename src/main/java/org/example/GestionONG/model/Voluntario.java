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

    @ManyToOne(optional = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombreCompleto")
    private Persona persona;

    @ManyToMany
    @ListPrope
