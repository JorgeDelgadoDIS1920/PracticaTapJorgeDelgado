package org.TAP.backend.model;

public enum TipoActuador {

    IMPRIMIR,ENVIAR_EMAIL;

    private static final IFabricaActuador[] fabricas= {new FabricaActuadorImprimir(),new FabricaActuadorEnviarEmail()};

    public IFabricaActuador getFabrica(){
        return fabricas[this.ordinal()];
    }
}
