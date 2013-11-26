package com.homenet.bootstrap.widgets;


import com.homenet.bootstrap.loader.BaseBootstrapUI;
import com.vaadin.ui.*;

import java.io.IOException;

public final class LoginComponent {
    private CustomLayout custom;

    public LoginComponent() {
        try {
            custom = new CustomLayout(BaseBootstrapUI.RESOURCES.get(BaseBootstrapUI.LOGINFORM_LAYOUT_STREAM));
        } catch (IOException e) {
            Notification.show("Can not load resources", Notification.Type.ERROR_MESSAGE);
        }
    }


    public Component getLoginComponent() {
        Panel panel = new Panel();
        panel.setSizeUndefined();
        assert custom != null;
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
