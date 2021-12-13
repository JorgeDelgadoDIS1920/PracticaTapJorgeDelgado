package org.TAP.backend.model;

public  class  Regla implements IObservadorSensor,IIdentificable{
    private long id;
    private Actuador actuador;
    private Condicion condicion;

    public Regla(long id, Actuador actuador, Condicion condicion) {
        this.id=id;
        this.actuador = actuador;
        this.condicion = condicion;
        //apunto como observador de todos los sensores que tienen mi condicion

        for(Sensor sensor:condicion.getSensores()){
            sensor.attach(this);
        }
    }
    public Regla(Actuador actuador, Condicion condicion) {
        this(-1,actuador,condicion);
    }

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public IIdentificable clonar() throws CloneNotSupportedException {
        return (IIdentificable) super.clone();
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    //cuando ocurra algun cambio evaluo la condicion para ver si he de hacer alguna accion

    @Override
    public void update() {
        if (this.condicion.evaluar()){
          actuador.realizarAccion();
        }

    }
}
