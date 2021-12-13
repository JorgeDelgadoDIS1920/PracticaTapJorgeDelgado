package org.TAP.backend.model;

import java.util.Locale;

public class SensorBooleano extends Sensor<Boolean> {


    public SensorBooleano() {
        super(TipoSensor.BOOLEANO);
    }
    public SensorBooleano(Long id,String nombre) {
        super(id,nombre,TipoSensor.BOOLEANO);
    }

    public SensorBooleano(String nombre) {
        super(nombre,TipoSensor.BOOLEANO);
    }

    @Override
    public void setValor(String valor) {
        this.valor = new Boolean(valor.toLowerCase());
        //notificamos a los observadores que el valor ha cambiado
        this.notificar();
    }

    @Override
    public void generarValorAleatorio() {
        this.valor=Math.random()<0.5;
    }


}
