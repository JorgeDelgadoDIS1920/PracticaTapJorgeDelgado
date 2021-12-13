package org.TAP.backend.model;

public class CondicionOr extends CondicionBinaria {


    public CondicionOr(Condicion condicion1, Condicion condicion2) {
        super(condicion1, condicion2,OperadorLogico.OR);
    }

    @Override
    public boolean evaluar() {
        return condicion1.evaluar()|| condicion2.evaluar();
    }
}
