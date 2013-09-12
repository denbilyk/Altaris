package com.homenet.bootstrap;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

@Theme("altaris")
@SuppressWarnings("serial")
public class BaseBootstrapUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = BaseBootstrapUI.class, widgetset = "com.homenet.bootstrap.BaseWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    private final CssLayout baseView = new CssLayout();
    private final CustomLayout baseLayout = new CustomLayout("baseLayout");

    @Override
    protected void init(VaadinRequest request) {
        baseView.setSizeUndefined();
        baseView.setId("container");
        setContent(baseView);
        baseView.addComponent(baseLayout);
        baseLayout.setStyleName("a-base-layout");
    }

    private Component getLoginForm(){
        Panel panel = new Panel("Login");
        panel.setSizeUndefined();

        CustomLayout custom = new CustomLayout("login-form");
        custom.addStyleName("customlayoutexample");
        panel.setContent(custom);

        TextField username = new TextField();
        custom.addComponent(username, "username");

        TextField password = new TextField();
        custom.addComponent(password, "password");

        Button ok = new Button("Login");
        custom.addComponent(ok, "okbutton");
        return panel;
    }
}
