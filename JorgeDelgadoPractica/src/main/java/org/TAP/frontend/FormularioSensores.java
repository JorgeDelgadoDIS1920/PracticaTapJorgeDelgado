package org.TAP.frontend;

import com.vaadin.ui.*;
import org.TAP.backend.controller.ControladorSensor;
import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.TipoSensor;

public class FormularioSensores extends FormLayout {
    private ControladorSensor service = ControladorSensor.getInstance();
    private Grid<Sensor> grid = new Grid<>(Sensor.class);
    private FormularioSensor formularioSensor = new FormularioSensor(this);

    public FormularioSensores() {


        VerticalLayout layoutIzquierdo = new VerticalLayout();
        VerticalLayout layoutDerecho = new VerticalLayout();
        HorizontalLayout mainContent = new HorizontalLayout(layoutIzquierdo,layoutDerecho);
        mainContent.setSizeFull();

        //layoutIzquierdo
        //añadimos botton añadir Sensor y su codigo correspondiente

        ComboBox<TipoSensor> tipo = new ComboBox<>("Tipo de sensor");
        tipo.setItems(TipoSensor.values());

        Button botonNuevoSensor = new Button("Añadir Sensor");
        botonNuevoSensor.addClickListener(e -> {
            grid.asSingleSelect().clear();
            if(tipo.getValue()==null){
                Notification.show("Error",
                        "Selecciona un tipo de sensor",
                        Notification.Type.HUMANIZED_MESSAGE);
            }
            else {
                formularioSensor.setSensor(tipo.getValue().getFabrica().fabricaSensor());
            }
        });
        //añadimos los botones al toolbar
        HorizontalLayout toolbar = new HorizontalLayout(tipo,
                botonNuevoSensor);


        grid.asSingleSelect().addValueChangeListener(event ->
                formularioSensor.setSensor(grid.asSingleSelect().getValue()));
        final VerticalLayout gridLayout = new VerticalLayout();

        layoutIzquierdo.addComponents(toolbar,gridLayout);
        //layoutderecho
        layoutDerecho.addComponent(formularioSensor);
        formularioSensor.setSensor(null);

        grid.setColumns("nombre", "valor");
        gridLayout.addComponent(grid);


        // layout.setAlignItems(Alignment.CENTER);//puts button in horizontal  center
        this.addComponents(mainContent);
        updateList();
    }
    public void updateList() {
        grid.setItems(service.findAll());
    }
}
