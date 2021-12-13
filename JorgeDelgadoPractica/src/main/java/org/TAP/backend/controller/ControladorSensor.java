package org.TAP.backend.controller;

import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.SensorBooleano;
import org.TAP.backend.model.SensorNumerico;

public class ControladorSensor extends Controlador<Sensor> {
    private static ControladorSensor instance;

    private ControladorSensor() {
        super();
    }

    public static ControladorSensor getInstance() {
        if (instance == null) {
            instance = new ControladorSensor();
        }
        return instance;
    }


    @Override
    public void ensureTestData() {
        if (findAll().isEmpty()) {
            Sensor sensor1 = new SensorBooleano("Puerta");
            save(sensor1);
            Sensor sensor2 = new SensorBooleano("Humo");
            save(sensor2);
            Sensor sensor3 = new SensorNumerico("Humedad");
            save(sensor3);
            Sensor sensor4 = new SensorNumerico("Temperatura");
            save(sensor4);


        }
    }
}
