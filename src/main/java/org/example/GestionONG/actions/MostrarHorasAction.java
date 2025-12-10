package org.example.GestionONG.actions;

import org.openxava.actions.*;
import org.example.GestionONG.model.*;
import java.util.*;
import org.openxava.jpa.*;
import java.text.*;

public class MostrarHorasAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        Date inicio = (Date) getView().getValue("fechaInicio");
        Date fin = (Date) getView().getValue("fechaFin");

        Map<String, Object> claveProyecto = (Map<String, Object>) getView().getValue("proyecto");
        String idProyectoSeleccionado = (claveProyecto != null) ? (String) claveProyecto.get("codigoProyecto") : null;

        closeDialog();

        Voluntario v = (Voluntario) getView().getEntity();
        v = XPersistence.getManager().merge(v);

        int totalHoras = 0;
        String nombreProyecto = "todos los proyectos";

        if (v.getParticipaciones() != null) {
            for (Participacion p : v.getParticipaciones()) {
                boolean cumpleProyecto = true;
                boolean cumpleFechas = true;

                if (idProyectoSeleccionado != null) {
                    if (!p.getProyecto().getCodigoProyecto().equals(idProyectoSeleccionado)) {
                        cumpleProyecto = false;
                    } else {
                        nombreProyecto = p.getProyecto().getNombre();
                    }
                }

                if (inicio != null && p.getFechaInicio().before(inicio)) cumpleFechas = false;
                if (fin != null && p.getFechaInicio().after(fin)) cumpleFechas = false;

                if (cumpleProyecto && cumpleFechas) {
                    totalHoras += p.getHorasRegistradas();
                }
            }
        }

        String mensaje = MessageFormat.format(
                "El voluntario {0} ha dedicado {1} horas a {2}.",
                v.getPersona().getNombreCompleto(),
                totalHoras,
                nombreProyecto
        );

        if (inicio != null || fin != null) {
            mensaje += " (En el periodo seleccionado)";
        }

        addMessage(mensaje);
    }
}