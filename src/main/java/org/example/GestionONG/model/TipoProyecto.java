package org.example.GestionONG.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

@Getter
@Setter
@Entity
public class TipoProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ReadOnly
    private Long id;

    @Required
    @Column(length = 100, unique = true)
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @Column(length = 255)
    @Size(max = 255, message = "La descripción no puede superar los 255 caracteres")
    @TextArea
    private String descripcion;
}