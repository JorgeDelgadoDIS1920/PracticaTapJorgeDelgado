package org.TAP.backend.model;

import java.io.Serializable;

public class CondicionSimpleIgual<T extends Comparable & Serializable> extends CondicionSimple<T>{

    public CondicionSimpleIgual(Sensor sensor, T valor) {
        super(sensor, OperadorRelacional.IGUAL, valor);
    }

    @Override
    public boolean evaluar() {
        return sensor.getValor().compareTo(valor)==0;
    }
}
