package org.example.GestionONG.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;
import org.apache.commons.lang3.text.WordUtils;

@Getter
@Setter
@Entity
public class Departamento {

    @Id
    @Column(length = 2)
    @Required
    @ReadOnly
    private Long id;

    @Required
    @Column(length = 50, unique = true)
    @Size(max = 50, message = "El nombre del departamento es muy largo")
    private String nombre;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MacroRegion region;

    @OneToMany(mappedBy = "departamento")
    @ListProperties("nombre")
    private List<Municipio> municipios;

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = WordUtils.capitalizeFully(nombre);
        } else {
            this.nombre = null;
        }
    }
}