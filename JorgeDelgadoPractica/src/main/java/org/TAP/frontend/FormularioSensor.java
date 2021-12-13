package org.TAP.frontend;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import org.TAP.backend.controller.Controlador;
import org.TAP.backend.controller.ControladorSensor;
import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.TipoSensor;

public class FormularioSensor extends FormLayout {

    private FormularioSensores vistaPrincipal;
    private ControladorSensor controlador = ControladorSensor.getInstance();
    private Binder<Sensor> binder = new Binder<Sensor>(Sensor.class);

    private TextField nombre = new TextField("Nombre");
    private TextField valor = new TextField("Valor");
    private ComboBox<TipoSensor> tipo = new ComboBox<>("Tipo de sensor");

    private Button botonSalvar = new Button("Salvar");
    private Button botonBorrar = new Button("Borrar");


    public FormularioSensor(FormularioSensores vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        tipo.setItems(TipoSensor.values());
        tipo.setEnabled(false);

        HorizontalLayout botones = new HorizontalLayout(botonSalvar, botonBorrar);
        //botonSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.addComponents(nombre, valor, tipo, botones);
        //binder.bindInstanceFields(this);
        binder.forField(nombre).bind(Sensor::getNombre,Sensor::setNombre);
        binder.forField(valor).bind(Sensor::getValorStr,Sensor::setValor);
        binder.forField(tipo).bind(Sensor::getTipo,Sensor::setTipo);

        botonSalvar.addClickListener(event -> salvar());
        botonBorrar.addClickListener(event -> borrar());
    }
    public void setSensor(Sensor sensor) {
        binder.setBean(sensor);

        if (sensor == null) {
            setVisible(false);
        } else {
            setVisible(true);
            nombre.focus();
        }
    }
    private void salvar() {
        Sensor sensor = binder.getBean();
        controlador.save(sensor);
        vistaPrincipal.updateList();
        setSensor(null);
    }
    private void borrar() {
        Sensor sensor = binder.getBean();
        controlador.delete(sensor);
        vistaPrincipal.updateList();
        setSensor(null);
    }

}
