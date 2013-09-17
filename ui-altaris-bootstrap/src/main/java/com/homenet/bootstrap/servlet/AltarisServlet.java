package com.homenet.bootstrap.servlet;


import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.VaadinServlet;

import java.util.Properties;

public class AltarisServlet extends VaadinServlet {

    @Override
    protected DeploymentConfiguration createDeploymentConfiguration(Properties initParameters) {
        initParameters.setProperty("ui", "com.homenet.bootstrap.loader.BaseBootstrapUI");
        initParameters.setProperty("widgetset", "com.homenet.bootstrap.BaseWidgetSet");
        return super.createDeploymentConfiguration(initParameters);
    }

}
