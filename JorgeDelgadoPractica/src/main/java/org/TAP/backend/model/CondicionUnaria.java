package org.TAP.backend.model;

import java.util.ArrayList;
//decorador 1
public abstract class CondicionUnaria extends Condicion{

    protected Condicion condicion;


    public CondicionUnaria(Condicion condicion) {
        this.condicion = condicion;

    }




    @Override
    public ArrayList<Sensor> getSensores() {
        return condicion.getSensores();
    }
}