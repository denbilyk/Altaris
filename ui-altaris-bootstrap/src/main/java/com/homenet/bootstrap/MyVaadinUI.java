package com.homenet.bootstrap;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

@Theme("altaris")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "com.homenet.bootstrap.BaseWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final CssLayout basic = new CssLayout();
        basic.setStyleName("basic-layout");
        setContent(basic);
        basic.setSizeFull();
        basic.addComponent(getLoginForm());
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
