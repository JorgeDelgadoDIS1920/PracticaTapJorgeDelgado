package org.TAP.backend.model;
import com.sun.org.apache.xpath.internal.objects.XString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Sensor<T extends Serializable & Comparable> implements Serializable,IIdentificable {

    protected long id;
    protected String nombre;
    protected T valor;
    protected TipoSensor tipo;
    protected ArrayList<IObservadorSensor> observadores;


    public Sensor(long id,String nombre,TipoSensor tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo=tipo;
        this.observadores=new ArrayList<>();
        generarValorAleatorio();

    }
    public Sensor(TipoSensor tipo) {
        this(-1,"Nombre",tipo);
    }


    public Sensor(String nombre,TipoSensor tipo) {

        this(-1,nombre,tipo);
    }
    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public T getValor() {
        return valor;
    }
    public String getValorStr() {
        return valor.toString();
    }

    public abstract void setValor(String valor) ;

    public String getNombre() {
        return nombre;
    }

    public abstract void generarValorAleatorio();

    public TipoSensor getTipo() {
        return tipo;
    }

    public void setTipo(TipoSensor tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor<?> sensor = (Sensor<?>) o;
        return id == sensor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sensor " + nombre;
    }
    @Override
    public IIdentificable clonar() throws CloneNotSupportedException {
        return (IIdentificable) super.clone();
    }

    public void attach(IObservadorSensor observer){
        observadores.add(observer);
    }

    public void detach(IObservadorSensor observer){
        observadores.remove(observer);
    }

    protected void notificar(){
        for ( IObservadorSensor observador : observadores){
            observador.update();
        }

    }

}
