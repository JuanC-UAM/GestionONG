package org.example.GestionONG.model;

import java.util.*;
import lombok.*;
import org.openxava.annotations.*;
import javax.persistence.*;

@Getter @Setter
public class FiltroHoras {

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList(descriptionProperties="nombre") // Combo con nombres de proyecto
    private Proyecto proyecto;

    private Date fechaInicio;
    private Date fechaFin;

}