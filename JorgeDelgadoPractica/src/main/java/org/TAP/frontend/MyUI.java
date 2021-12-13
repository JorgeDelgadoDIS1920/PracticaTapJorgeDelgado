package org.TAP.frontend;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.TAP.backend.controller.Controlador;
import org.TAP.backend.controller.ControladorSensor;
import org.TAP.backend.model.Sensor;
import org.TAP.backend.model.TipoSensor;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {



    @Override
    protected void init(VaadinRequest vaadinRequest) {

        TabSheet pestañas = new TabSheet();
        pestañas.addTab(new FormularioSensores(),"Sensores");
        pestañas.addTab(new FormularioActuadores(),"Actuadores");
        pestañas.addTab(new FormularioReglas(),"Reglas");
        HorizontalLayout mainContent = new HorizontalLayout(pestañas);
        mainContent.setSizeFull();


        setContent(mainContent);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}
