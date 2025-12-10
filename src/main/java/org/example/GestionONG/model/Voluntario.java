package org.example.GestionONG.model;

import javax.persistence.*; // JPA estándar
import javax.validation.constraints.*; // Necesario para @Past y @Required implícito
import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Voluntario {

    public enum TipoSangre { A, B, AB, O }
    // Nota: 'NULL' es válido, pero 'DESCONOCIDO' o 'NINGUNO' suele ser menos confuso. Lo dejo como lo tenías.
    public enum FactorRH { NULL, POSITIVO, NEGATIVO }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    @Column(name = "fecha_nacimiento")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada") // Requiere javax.validation.constraints
    private Date fechaNacimiento;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    private TipoSangre tipoSangre;

    @Required
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private FactorRH rh;

    // Relación con Persona (Datos demográficos)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ReferenceView("Simple") // Opcional: Para ver una vista simplificada de Persona si la tienes
    @Required
    @DescriptionsList(descriptionProperties = "nombreCompleto") // Muestra el nombre en el combo
    private Persona persona;

    // --- SECCIÓN COMPLETADA ---
    // He asumido que la relación @ManyToMany es con "Habilidad".
    // Si tu clase se llama diferente, cambia "Habilidad" por el nombre correcto.

    @ManyToMany(fetch = FetchType.LAZY)
    @ListProperties("nombre, descripcion") // Propiedades a mostrar de la tabla Habilidad
    private Collection<Habilidad> habilidades;

    // También es común tener la lista de proyectos donde participa (OneToMany)
    @OneToMany(mappedBy = "voluntario")
    @ListProperties("proyecto.nombre, rolEnProyecto, fechaInicio, horasRegistradas")
    private Collection<Participacion> participaciones;
}