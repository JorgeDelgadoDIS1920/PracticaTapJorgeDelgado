package org.TAP.backend.model;

public class FabricaSensorNumerico implements IFabricaSensor{

    @Override
    public Sensor fabricaSensor() {
        return new SensorNumerico();
    }
}
