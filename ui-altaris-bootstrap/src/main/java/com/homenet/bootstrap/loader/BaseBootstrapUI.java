package com.homenet.bootstrap.loader;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
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
public final class BaseBootstrapUI extends UI {

/*    @WebServlet(value = "*//*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = BaseBootstrapUI.class, widgetset = "com.homenet.bootstrap.BaseWidgetSet")
    public static class Servlet extends VaadinServlet {
    }*/

    private CSSInject cssInject;

    public static final String BASE_LAYOUT_STREAM = "baseLayout";
    public static final String LOGINFORM_LAYOUT_STREAM = "loginFormLayout";
    public static Map<String, InputStream> RESOURCES = new HashMap<String, InputStream>();


    @Override
    protected void init(VaadinRequest request) {
        try {
            loadResources();
            cssInject = new CSSInject(getUI());
            CssLayout baseView = new CssLayout();
            CustomLayout baseLayout = new CustomLayout(RESOURCES.get(BASE_LAYOUT_STREAM));
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
        InputStream loginFormLayoutStream = getClass().getResourceAsStream("/VAADIN/themes/" + getTheme() + "/layouts/login-form.html");
        RESOURCES.put(BASE_LAYOUT_STREAM, baseLayoutStream);
        RESOURCES.put(LOGINFORM_LAYOUT_STREAM, loginFormLayoutStream);
    }

}
