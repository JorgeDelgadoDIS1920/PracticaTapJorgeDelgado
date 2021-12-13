package org.TAP.backend.model;

import java.util.ArrayList;

public class CondicionAnd extends CondicionBinaria{


    public CondicionAnd(Condicion condicion1, Condicion condicion2) {
        super(condicion1, condicion2,OperadorLogico.AND);
    }

    @Override
    public boolean evaluar() {
        return condicion1.evaluar() && condicion2.evaluar();
    }

    @Override
    public ArrayList<Sensor> getSensores() {
        ArrayList<Sensor> sensores= new ArrayList<Sensor>();
        sensores.addAll(condicion1.getSensores());
        sensores.addAll(condicion2.getSensores());
        return sensores;

    }
}
