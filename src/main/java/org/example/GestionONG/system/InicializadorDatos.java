package org.example.GestionONG.system;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.persistence.*;
import org.openxava.jpa.*;
import org.example.GestionONG.model.*;
import java.util.*;

@WebListener
public class InicializadorDatos implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--- INICIANDO SEMBRADO DE DATOS (DATA SEEDING) ---");

        EntityManager em = null;
        try {
            em = XPersistence.createManager();
            em.getTransaction().begin();

            Departamento dep = em.find(Departamento.class, 1L);

            if (dep == null) {
                System.out.println("Base de datos de Departamentos vacía. Insertando datos...");
                crearDepartamentos(em);
            } else {
                System.out.println("Departamentos ya existen. No se requiere acción.");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Nada que hacer al cerrar
    }

    private void crearDepartamentos(EntityManager em) {
        crearDep(em, 1L, "Boaco", MacroRegion.CENTRO_NORTE);
        crearDep(em, 2L, "Carazo", MacroRegion.PACIFICO);
        crearDep(em, 3L, "Chinandega", MacroRegion.PACIFICO);
        crearDep(em, 4L, "Chontales", MacroRegion.CENTRO_NORTE);
        crearDep(em, 5L, "Estelí", MacroRegion.CENTRO_NORTE);
        crearDep(em, 6L, "Granada", MacroRegion.PACIFICO);
        crearDep(em, 7L, "Jinotega", MacroRegion.CENTRO_NORTE);
        crearDep(em, 8L, "León", MacroRegion.PACIFICO);
        crearDep(em, 9L, "Madriz", MacroRegion.CENTRO_NORTE);
        crearDep(em, 10L, "Managua", MacroRegion.PACIFICO);
        crearDep(em, 11L, "Masaya", MacroRegion.PACIFICO);
        crearDep(em, 12L, "Matagalpa", MacroRegion.CENTRO_NORTE);
        crearDep(em, 13L, "Nueva Segovia", MacroRegion.CENTRO_NORTE);
        crearDep(em, 14L, "Rivas", MacroRegion.PACIFICO);
        crearDep(em, 15L, "Río San Juan", MacroRegion.CENTRO_NORTE);
        crearDep(em, 16L, "RACCN", MacroRegion.COSTA_CARIBE);
        crearDep(em, 17L, "RACCS", MacroRegion.COSTA_CARIBE);
    }

    private void crearDep(EntityManager em, Long id, String nombre, MacroRegion region) {
        Departamento d = new Departamento();
        d.setId(id);
        d.setNombre(nombre);
        d.setRegion(region);
        em.persist(d); // Guardamos
        System.out.println(" -> Insertado: " + nombre);
    }
}