package org.example.GestionONG.actions;

import org.openxava.actions.*;

public class AutorizarGastoAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        if (getView().getValue("id") == null) {
            addError("Error: Se debe guardar el Coordinador antes de autorizar gastos.");
            return;
        }

        showDialog();

        getView().setModelName("DatosAutorizacion");
        getView().setTitle("Autorizar Nuevo Gasto");

        setControllers("DialogoAutorizacion");
    }
}