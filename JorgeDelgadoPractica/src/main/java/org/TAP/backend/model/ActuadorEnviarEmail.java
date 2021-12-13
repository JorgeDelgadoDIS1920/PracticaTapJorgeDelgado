package org.TAP.backend.model;

public class ActuadorEnviarEmail extends Actuador {


    private String mensaje;



    public ActuadorEnviarEmail(long id,String mensaje,String nombre) {
       super(id,nombre,TipoActuador.ENVIAR_EMAIL);
        this.mensaje = mensaje;

    }
    public ActuadorEnviarEmail(String mensaje,String nombre) {
        this(-1,mensaje,nombre);
    }
    public ActuadorEnviarEmail() {
        this(-1,null,null);
    }



    @Override
    public void realizarAccion() {

        System.out.println("email enviado:"+mensaje);
    }


    @Override
    public String getAccion() {
        if(mensaje==null){
            return "introduce el mensaje";
        }
        else
        return "Enviar email con el mensaje : "+ mensaje;
    }


    @Override
    public IIdentificable clonar() throws CloneNotSupportedException {
        return (IIdentificable) super.clone();
    }


}

