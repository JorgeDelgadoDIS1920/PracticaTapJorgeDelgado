package org.TAP.backend.model;

import java.io.Serializable;

public abstract class Actuador implements IIdentificable, Serializable {

    private long id;
    private String nombre;
    private TipoActuador tipo;



    public Actuador(long id,String nombre, TipoActuador tipo) {
        this.id=id;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public Actuador() {
        this(-1,null,null);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public TipoActuador getTipo() {
        return tipo;
    }

    public void setTipo(TipoActuador tipo) {
        this.tipo = tipo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  abstract String getAccion();
    public  abstract void realizarAccion();

    @Override
    public String toString() {
        return "Actuador " + nombre ;

    }
}
