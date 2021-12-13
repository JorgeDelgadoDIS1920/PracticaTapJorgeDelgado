package org.TAP.backend.model;

import java.io.Serializable;
import java.util.ArrayList;
//componente concreto del decorador
public abstract class CondicionSimple<T extends Serializable & Comparable> extends Condicion{

    protected Sensor<T> sensor;
    protected OperadorRelacional operador;
    protected T valor;



    public CondicionSimple(Sensor<T> sensor, OperadorRelacional operador, T valor) {
        this.sensor = sensor;
        this.operador = operador;
        this.valor = valor;
    }

    @Override
    public ArrayList<Sensor> getSensores() {
        ArrayList<Sensor> sensores= new ArrayList<Sensor>();
        sensores.add(sensor);
        return sensores ;
    }

    /*  @Override
   public boolean evaluar() {
        switch (operador) {
            case MAYOR:
                return sensor.getValor().compareTo(valor)>0;
            case MENOR:
                return sensor.getValor().compareTo(valor)<0;
            case MAYORIGUAL:
                return sensor.getValor().compareTo(valor)>=0;
            case MENORIGUAL:
                return sensor.getValor().compareTo(valor)<=0;
            case IGUAL:
                return sensor.getValor().compareTo(valor)==0;
            case DISTINTO:
                return sensor.getValor().compareTo(valor)!=0;
            default:
                return false;
        }
    }*/

    @Override
    public String toString() {
        return "sensor " + sensor.getNombre() +
                 operador +
                 valor ;
    }
}
