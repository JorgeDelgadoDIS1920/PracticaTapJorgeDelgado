package org.TAP.backend.model;

import java.util.ArrayList;

public class CondicionNot extends CondicionUnaria{


    public CondicionNot(Condicion condicion) {
        super(condicion);
    }

    @Override
    public boolean evaluar() {
        return !condicion.evaluar();
    }

    @Override
    public String toString() {
        return "NOT ("+ condicion.toString()+")";
    }
}
