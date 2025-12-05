package org.example.GestionONG.actions;

import org.openxava.actions.ViewBaseAction;
import org.example.GestionONG.model.Coordinador;
import java.math.BigDecimal;

public class AutorizarGastoAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        Coordinador c = (Coordinador) getView().getEntity();
        // Aquí la lógica real; por ejemplo:
        BigDecimal monto = new BigDecimal("1000.00");
        c.autorizarGasto(monto);
        addMessage("Gasto autorizado por " + c.getPersona().getNombreCompleto());
    }
}