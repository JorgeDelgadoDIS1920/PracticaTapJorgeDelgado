package org.TAP.backend.controller;

import org.TAP.backend.model.*;

public class ControladorRegla extends Controlador{

    private static ControladorRegla instance;

    private ControladorRegla() {
        super();
    }

    public static ControladorRegla getInstance() {
        if (instance == null) {
            instance = new ControladorRegla();
        }
        return instance;
    }


    @Override
    public void ensureTestData() {
        if (findAll().isEmpty()) {

            Sensor sensorPuerta=ControladorSensor.getInstance().findAll("Puerta").get(0);
            Sensor sensorHumo=ControladorSensor.getInstance().findAll("Humo").get(0);
            Sensor sensorHumedad=ControladorSensor.getInstance().findAll("Humedad").get(0);
            Sensor sensorTemperatura=ControladorSensor.getInstance().findAll("Temperatura").get(0);

            CondicionSimpleIgual condicionPuertaCerrada=new CondicionSimpleIgual(sensorPuerta,false);
            CondicionSimpleIgual condicionHumo=new CondicionSimpleIgual(sensorHumo,true);
            CondicionAnd condicionPuertaCerradaHumo= new CondicionAnd(condicionHumo,condicionPuertaCerrada);
            CondicionSimpleMayor condicionCalor=new CondicionSimpleMayor(sensorTemperatura,30);
            CondicionSimpleMenor condicionHumedad=new CondicionSimpleMenor(sensorHumedad,10);
            CondicionOr condicionCalorHumedad = new CondicionOr(condicionCalor,condicionHumedad);

            Actuador actuadorEvacuar=ControladorActuador.getInstance().findAll("evacuacion").get(0);
            Actuador actuadorAviso =ControladorActuador.getInstance().findAll("email aviso").get(0);

            Regla reglaEvacuar = new Regla(actuadorEvacuar,condicionPuertaCerradaHumo);
            Regla reglaAviso = new Regla(actuadorAviso,condicionCalorHumedad);

            this.save(reglaEvacuar);
            this.save(reglaAviso);


        }
    }
}
