package org.TAP.backend.model;

public class FabricaActuadorImprimir implements IFabricaActuador{

    @Override
    public Actuador fabricaActuador() {
        return new ActuadorImprimir();
    }
}
