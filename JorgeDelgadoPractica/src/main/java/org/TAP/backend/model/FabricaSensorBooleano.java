package org.TAP.backend.model;

public class FabricaSensorBooleano implements IFabricaSensor{
    @Override
    public Sensor fabricaSensor() {
        return new SensorBooleano();
    }
}
