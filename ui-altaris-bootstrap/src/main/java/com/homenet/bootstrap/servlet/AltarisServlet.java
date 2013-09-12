package com.homenet.bootstrap.servlet;


import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.VaadinServlet;

import java.util.Properties;

public class AltarisServlet extends VaadinServlet {

    @Override
    protected DeploymentConfiguration createDeploymentConfiguration(Properties initParameters) {
        initParameters.setProperty("ui", "BaseBootstrapUI");
        initParameters.setProperty("widgetset", "com.homenet.bootstrap.BaseWidgetSet");
        initParameters.setProperty("productionMode", "false");
        return super.createDeploymentConfiguration(initParameters);
    }

}
