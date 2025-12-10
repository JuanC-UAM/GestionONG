package org.example.GestionONG.actions;

import org.openxava.actions.*;

public class CalcularHorasTotalesAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        if (getView().getValue("id") == null) {
            addError("Primero hay que guardar el voluntario.");
            return;
        }

        showDialog();
        getView().setModelName("FiltroHoras");
        getView().setTitle("Calcular Horas por Periodo");

        setControllers("DialogoCalcularHoras");
    }
}