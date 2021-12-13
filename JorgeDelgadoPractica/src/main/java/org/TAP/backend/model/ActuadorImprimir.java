package org.TAP.backend.model;

public class ActuadorImprimir extends Actuador {


    private String mensaje;



    public ActuadorImprimir(long id, String mensaje,String nombre) {
        super(id,nombre,TipoActuador.IMPRIMIR);
        this.mensaje = mensaje;

    }
    public ActuadorImprimir(String mensaje,String nombre) {
      this(-1,mensaje,nombre);
    }
    public ActuadorImprimir() {
        this(-1,null,null);

    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }



    @Override
    public String getAccion() {
        if(mensaje==null){
            return "introduce el mensaje";
        }
        else
        return "Imprime el mensaje:" + mensaje;
    }


    @Override
    public void realizarAccion() {
        System.out.println(mensaje);
    }



    @Override
    public IIdentificable clonar() throws CloneNotSupportedException {
        return (IIdentificable) super.clone();
    }


}
