package org.example.GestionONG.actions;

import org.openxava.actions.ViewBaseAction;
import org.example.GestionONG.model.Voluntario;

public class CalcularHorasTotalesAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        Voluntario v = (Voluntario) getView().getEntity();
        int horas = v.calcularHorasTotales();
        addMessage("Horas totales: " + horas);
    }
}