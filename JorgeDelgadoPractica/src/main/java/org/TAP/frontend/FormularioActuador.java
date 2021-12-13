package org.TAP.frontend;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import org.TAP.backend.controller.ControladorActuador;
import org.TAP.backend.model.Actuador;
import org.TAP.backend.model.TipoActuador;

public class FormularioActuador extends FormLayout {
    private FormularioActuadores vistaPrincipal;
    //singleton
    private ControladorActuador controlador = ControladorActuador.getInstance();
    private Binder<Actuador> binder = new Binder<Actuador>(Actuador.class);

    private TextField nombre = new TextField("Nombre");
    private TextField accion = new TextField("Mensaje");
    private ComboBox<TipoActuador> tipo = new ComboBox<>("Tipo de Actuador");

    private Button botonSalvar = new Button("Salvar");
    private Button botonBorrar = new Button("Borrar");


    public FormularioActuador(FormularioActuadores vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        tipo.setItems(TipoActuador.values());
        tipo.setEnabled(false);

        HorizontalLayout botones = new HorizontalLayout(botonSalvar, botonBorrar);
        //botonSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.addComponents(nombre, accion, tipo, botones);
        //binder.bindInstanceFields(this);
        //solucionar clase Iactuador?
        binder.forField(nombre).bind(Actuador::getNombre, Actuador::setNombre);
        binder.forField(accion).bind(Actuador::getAccion,null);

       // binder.forField(tipo).bind(Sensor::getTipo,Sensor::setTipo);

        botonSalvar.addClickListener(event -> salvar());
        botonBorrar.addClickListener(event -> borrar());
    }
    public void setActuador(Actuador actuador) {
        binder.setBean(actuador);

        if (actuador == null) {
            setVisible(false);
        } else {
            setVisible(true);
            nombre.focus();
        }
    }
    private void salvar() {
        Actuador actuador = binder.getBean();
        controlador.save(actuador);
        vistaPrincipal.updateList();
        setActuador(null);
    }
    private void borrar() {
        Actuador actuador = binder.getBean();
        controlador.delete(actuador);
        vistaPrincipal.updateList();
        setActuador(null);
    }

}
