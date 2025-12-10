package org.example.GestionONG.model;

import javax.persistence.*; // JPA estándar
import javax.validation.constraints.*; // Necesario para @Size
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

    @Column(length = 100, unique = true) // 'unique = true' evita nombres duplicados en la BD
    @Required
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres") // Reemplazo de @MaxSize
    private String nombre;

    @Column(length = 255)
    @Size(max = 255, message = "La descripción es muy larga") // Reemplazo de @MaxSize
    @Stereotype("MEMO") // En OpenXava, "MEMO" es la forma correcta de mostrar un área de texto grande
    private String descripcion;
}