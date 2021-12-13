package org.TAP.frontend;

import com.vaadin.ui.*;
import org.TAP.backend.controller.ControladorRegla;
import org.TAP.backend.model.Regla;
import org.TAP.backend.model.TipoSensor;

public class FormularioReglas extends FormLayout {
    private ControladorRegla service = ControladorRegla.getInstance();
    private Grid<Regla> grid = new Grid<>(Regla.class);
    private FormularioRegla formularioRegla = new FormularioRegla(this);

    public FormularioReglas() {


        VerticalLayout layoutIzquierdo = new VerticalLayout();
        VerticalLayout layoutDerecho = new VerticalLayout();
        HorizontalLayout mainContent = new HorizontalLayout(layoutIzquierdo,layoutDerecho);
        mainContent.setSizeFull();

        //layoutIzquierdo
        //añadimos botton añadir Sensor y su codigo correspondiente



        Button botonNuevoRegla = new Button("Añadir Regla");
        botonNuevoRegla.addClickListener(e -> {
            grid.asSingleSelect().clear();


        });
        //añadimos los botones al toolbar
        HorizontalLayout toolbar = new HorizontalLayout(
                botonNuevoRegla);


        grid.asSingleSelect().addValueChangeListener(event ->
                formularioRegla.setRegla(grid.asSingleSelect().getValue()));
        final VerticalLayout gridLayout = new VerticalLayout();

        layoutIzquierdo.addComponents(toolbar,gridLayout);
        //layoutderecho
        layoutDerecho.addComponent(formularioRegla);
        formularioRegla.setRegla(null);

        grid.setColumns("condicion","actuador");
        gridLayout.addComponent(grid);

        grid.setWidth("750px");
        grid.getColumn("condicion").setMinimumWidth(500);
        grid.getColumn("actuador").setWidth(250);



        // layout.setAlignItems(Alignment.CENTER);//puts button in horizontal  center
        this.addComponents(mainContent);
        updateList();
    }
    public void updateList() {
        grid.setItems(service.findAll());
    }
}