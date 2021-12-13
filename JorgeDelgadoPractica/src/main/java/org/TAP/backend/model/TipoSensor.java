package org.TAP.backend.model;

public enum TipoSensor {

    NUMERICO,BOOLEANO;

    private static final IFabricaSensor[] fabricas= {new FabricaSensorNumerico(),new FabricaSensorBooleano()};

    public IFabricaSensor getFabrica(){
        return fabricas[this.ordinal()];
    }
}
