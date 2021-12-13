package org.TAP.frontend;

import com.vaadin.ui.*;
import org.TAP.backend.controller.ControladorActuador;
import org.TAP.backend.model.Actuador;
import org.TAP.backend.model.TipoActuador;

public class FormularioActuadores extends FormLayout {
    private ControladorActuador service = ControladorActuador.getInstance();
    private Grid<Actuador> grid = new Grid<>(Actuador.class);
    private FormularioActuador formularioActuador = new FormularioActuador(this);

    public FormularioActuadores() {


        VerticalLayout layoutIzquierdo = new VerticalLayout();
        VerticalLayout layoutDerecho = new VerticalLayout();
        HorizontalLayout mainContent = new HorizontalLayout(layoutIzquierdo,layoutDerecho);
        mainContent.setSizeFull();

        //layoutIzquierdo
        //añadimos botton añadir Sensor y su codigo correspondiente

        ComboBox<TipoActuador> tipo = new ComboBox<>("Tipo de Actuador");
        tipo.setItems(TipoActuador.values());

        Button botonNuevoActuador = new Button("Añadir Actuador");
        botonNuevoActuador.addClickListener(e -> {
            grid.asSingleSelect().clear();
            if(tipo.getValue()==null){
                Notification.show("Error",
                        "Selecciona un tipo de actuador",
                        Notification.Type.HUMANIZED_MESSAGE);
            }
            else {
                formularioActuador.setActuador(tipo.getValue().getFabrica().fabricaActuador());
            }
        });
        //añadimos los botones al toolbar
        HorizontalLayout toolbar = new HorizontalLayout(tipo,
                botonNuevoActuador);


        grid.asSingleSelect().addValueChangeListener(event ->
                formularioActuador.setActuador(grid.asSingleSelect().getValue()));
        final VerticalLayout gridLayout = new VerticalLayout();

        layoutIzquierdo.addComponents(toolbar,gridLayout);
        //layoutderecho
        layoutDerecho.addComponent(formularioActuador);
        formularioActuador.setActuador(null);

        grid.setColumns("nombre", "accion");
        gridLayout.addComponent(grid);


        // layout.setAlignItems(Alignment.CENTER);//puts button in horizontal  center
        this.addComponents(mainContent);
        updateList();
    }
    public void updateList() {
        grid.setItems(service.findAll());
    }
}
