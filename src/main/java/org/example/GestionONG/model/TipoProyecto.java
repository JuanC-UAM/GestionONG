package org.example.GestionONG.model;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
public class TipoProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    @Column(length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;
}
