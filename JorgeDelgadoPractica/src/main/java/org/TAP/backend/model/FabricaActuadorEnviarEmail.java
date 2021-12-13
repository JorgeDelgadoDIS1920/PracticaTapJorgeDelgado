package org.TAP.backend.model;

public class FabricaActuadorEnviarEmail implements IFabricaActuador {


    @Override
    public Actuador fabricaActuador() {
        return new ActuadorEnviarEmail();
    }
}