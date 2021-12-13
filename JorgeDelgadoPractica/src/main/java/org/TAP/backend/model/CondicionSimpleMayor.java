package org.TAP.backend.model;

import java.io.Serializable;

public class CondicionSimpleMayor<T extends Comparable & Serializable> extends CondicionSimple<T>{

    public CondicionSimpleMayor(Sensor sensor,  T valor) {
        super(sensor, OperadorRelacional.MAYOR, valor);
    }

    @Override
    public boolean evaluar() {
        return sensor.getValor().compareTo(valor)>0;
    }
}
