package org.TAP.backend.model;

public class SensorNumerico extends Sensor<Double>{


    public SensorNumerico() {
        super(TipoSensor.NUMERICO);
    }
    public SensorNumerico(Long id,String nombre) {
        super(id,nombre,TipoSensor.NUMERICO);
    }

    public SensorNumerico(String nombre) {
        super(nombre,TipoSensor.NUMERICO);
    }

    @Override
    public void setValor(String valor) {
        this.valor = new Double(valor);
        //notificamos a los observadores que el valor ha cambiado
        this.notificar();
    }

    @Override
    public void generarValorAleatorio() {
        this.valor=Math.random()*100;
    }


}
