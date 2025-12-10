package org.example.GestionONG.actions;

import org.openxava.actions.*;
import org.example.GestionONG.model.*;
import java.math.*;
import java.util.*; // Para usar Map
import org.openxava.jpa.*;
import java.text.MessageFormat;

public class ConfirmarAutorizacionAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        BigDecimal monto = (BigDecimal) getView().getValue("monto");

        Map<String, Object> claveProyecto = (Map<String, Object>) getView().getValue("proyecto");

        if (claveProyecto == null || claveProyecto.isEmpty()) {
            addError("El proyecto es obligatorio");
            return;
        }

        String codigo = (String) claveProyecto.get("codigoProyecto");
        Proyecto proyecto = XPersistence.getManager().find(Proyecto.class, codigo);

        BigDecimal fondosActuales = proyecto.getFondos() != null ? proyecto.getFondos() : BigDecimal.ZERO;

        if (fondosActuales.compareTo(monto) < 0) {
            addError("Fondos insuficientes en el proyecto {0}. Disponibles: {1}",
                    proyecto.getNombre(), fondosActuales);
            return;
        }

        proyecto.setFondos(fondosActuales.subtract(monto));
        XPersistence.getManager().merge(proyecto);

        closeDialog();

        Coordinador c = (Coordinador) getView().getEntity();
        String mensaje = MessageFormat.format("Gasto de {0} autorizado para ''{1}''. Nuevo saldo: {2}",
                monto,
                proyecto.getNombre(),
                proyecto.getFondos());

        addMessage(mensaje);
    }
}