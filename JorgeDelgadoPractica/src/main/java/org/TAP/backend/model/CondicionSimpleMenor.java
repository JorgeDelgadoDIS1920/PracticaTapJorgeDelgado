package org.TAP.backend.model;

import java.io.Serializable;

public class CondicionSimpleMenor <T extends Comparable & Serializable> extends CondicionSimple<T>{
    public CondicionSimpleMenor(Sensor<T> sensor, T valor) {
        super(sensor, OperadorRelacional.MENOR, valor);
    }

    @Override
    public boolean evaluar() {

        return sensor.getValor().compareTo(valor)<0;
    }
}
