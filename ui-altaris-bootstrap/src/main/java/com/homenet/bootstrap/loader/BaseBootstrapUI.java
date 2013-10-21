package com.homenet.bootstrap.loader;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.reflections.Reflections;
import org.vaadin.cssinject.CSSInject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Theme("altaris")
@SuppressWarnings("serial")
public class BaseBootstrapUI extends UI {

/*    @WebServlet(value = "*//*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = BaseBootstrapUI.class, widgetset = "com.homenet.bootstrap.BaseWidgetSet")
    public static class Servlet extends VaadinServlet {
    }*/

    private static final String BASE_LAYOUT_STREAM = "baseLayout";
    private Map<String, InputStream> resources = new HashMap<String, InputStream>();
    private CSSInject cssInject;

    @Override
    protected void init(VaadinRequest request) {
        try {
            loadResources();
            cssInject = new CSSInject(getUI());
            CssLayout baseView = new CssLayout();
            CustomLayout baseLayout = new CustomLayout(resources.get(BASE_LAYOUT_STREAM));
            baseView.setSizeUndefined();
            baseView.setId("container");
            setContent(baseView);
            baseView.addComponent(baseLayout);
            baseLayout.setStyleName("a-base-layout");
            Reflections reflections = new Reflections("");
            //TODO Only one implementation can be implement
            Set<Class<? extends UIRootLoader>> subTypes = reflections.getSubTypesOf(UIRootLoader.class);
            for (Class<? extends UIRootLoader> subType : subTypes) {
                UIRootLoader uiRootLoader = subType.newInstance();
                uiRootLoader.getRootFactory(new RootLayoutFactory(baseLayout, cssInject));
            }

        } catch (IOException e) {
            Notification.show("Can not load resources", Notification.Type.ERROR_MESSAGE);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void loadResources() {
        InputStream baseLayoutStream = getClass().getResourceAsStream("/VAADIN/themes/" + getTheme() + "/layouts/baseLayout.html");
        resources.put(BASE_LAYOUT_STREAM, baseLayoutStream);
    }

    private Component getLoginForm() {
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
