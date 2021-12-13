package org.TAP.frontend;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import org.TAP.backend.controller.ControladorRegla;
import org.TAP.backend.controller.ControladorSensor;
import org.TAP.backend.model.Regla;
import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.TipoSensor;

public class FormularioRegla extends FormLayout {
    private FormularioReglas vistaPrincipal;
    private ControladorRegla controlador = ControladorRegla.getInstance();
    private Binder<Regla> binder = new Binder<Regla>(Regla.class);

  //  private TextField nombre = new TextField("Nombre");
  //  private TextField valor = new TextField("Valor");

    private Button botonSalvar = new Button("Salvar");
    private Button botonBorrar = new Button("Borrar");


    public FormularioRegla(FormularioReglas vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;


        HorizontalLayout botones = new HorizontalLayout(botonSalvar, botonBorrar);
        //botonSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.addComponents(/*nombre, valor,*/ botones);
        //binder.bindInstanceFields(this);
       // binder.forField(nombre).bind(Sensor::getNombre,Sensor::setNombre);
       // binder.forField(valor).bind(Sensor::getValorStr,Sensor::setValor);

        botonSalvar.addClickListener(event -> salvar());
        botonBorrar.addClickListener(event -> borrar());
    }
    public void setRegla(Regla regla) {
        binder.setBean(regla);

        if (regla == null) {
            setVisible(false);
        } else {
            setVisible(true);
           // nombre.focus();
        }
    }
    private void salvar() {
        Regla regla = binder.getBean();
        controlador.save(regla);
        vistaPrincipal.updateList();
        setRegla(null);
    }
    private void borrar() {
        Regla regla = binder.getBean();
        controlador.delete(regla );
        vistaPrincipal.updateList();
        setRegla(null);
    }

}
