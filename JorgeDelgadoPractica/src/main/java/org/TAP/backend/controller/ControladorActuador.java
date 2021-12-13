package org.TAP.backend.controller;

import org.TAP.backend.model.ActuadorEnviarEmail;
import org.TAP.backend.model.ActuadorImprimir;
import org.TAP.backend.model.Actuador;

public class ControladorActuador extends Controlador<Actuador> {
    private static ControladorActuador instance;

    private ControladorActuador() {
        super();
    }

    public static ControladorActuador getInstance() {
        if (instance == null) {
            instance = new ControladorActuador();
        }
        return instance;
    }


    @Override
    public void ensureTestData() {
        if (findAll().isEmpty()) {
            ActuadorImprimir actuadorImprimir1 = new ActuadorImprimir("Evacuar!","evacuacion");
            save(actuadorImprimir1);
            ActuadorEnviarEmail actuadorEnviarEmail = new ActuadorEnviarEmail("Aviso!","email aviso");
            save(actuadorEnviarEmail);


        }
    }
}
