package org.example.GestionONG.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required // ''Evita crear departamentos sin nombre''
    @Column(length = 50)
    private String nombre;

    @Required // ''Obliga a seleccionar la macro región correspondiente''
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MacroRegion region;

    @OneToMany(mappedBy = "departamento")
    @ListProperties("nombre")
    private List<Municipio> municipios; // ''Relación informativa, se carga automáticamente''
}

