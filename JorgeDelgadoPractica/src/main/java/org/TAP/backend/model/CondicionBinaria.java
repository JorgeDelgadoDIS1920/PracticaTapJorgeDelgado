package org.TAP.backend.model;

import java.util.ArrayList;
//decorador
public abstract class CondicionBinaria extends Condicion{

    protected Condicion condicion1;
    protected Condicion condicion2;
    protected OperadorLogico operador;

    public CondicionBinaria(Condicion condicion1, Condicion condicion2,OperadorLogico operador) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
        this.operador=operador;
    }




    @Override
    public ArrayList<Sensor> getSensores() {
        ArrayList<Sensor> sensores= new ArrayList<Sensor>();
        sensores.addAll(condicion1.getSensores());
        sensores.addAll(condicion2.getSensores());
        return sensores;

    }
    public String toString() {
        return "( " + condicion1.toString() +")"+
                operador +"( " + condicion2.toString() +")";
    }
}