package com.homenet.demo.ui;


import com.homenet.bootstrap.loader.RootLayoutFactory;
import com.homenet.bootstrap.loader.UIRootLoader;
import com.homenet.bootstrap.widgets.LoginComponent;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;
import org.vaadin.jouni.animator.Animator;

import java.io.InputStream;


public class CustomBaseLayout implements UIRootLoader {

    @Override
    public void getRootFactory(final RootLayoutFactory factory) {
        final Window w = new Window();
        final LoginComponent loginComp = new LoginComponent();
        w.setStyleName(Reindeer.WINDOW_LIGHT);
        w.setCaption("Login Form");
        w.setContent(loginComp.getLoginComponent());
        w.setResizable(false);
        w.setModal(true);
        w.center();

        Button btn = new Button("test");
        btn.setStyleName(Reindeer.BUTTON_SMALL);
        btn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().addWindow(w);
            }
        });

        factory.setCompositionPage(btn);
        InputStream is = getClass().getResourceAsStream("/img/logo.png");
        factory.customizeLogo(is);
        CssLayout comp = new CssLayout(new Label("MenuItem"));
        comp.setStyleName("us-menu-layout");
        InputStream cssSource = getClass().getResourceAsStream("/styles/styles.css");
        factory.addCSSSource(cssSource);
        factory.customizeTopMenuCol2(comp);
        factory.customizeTopMenuCol3(new Label("MenuItem3"));
        factory.customizeTopMenuCol4(new Label("MenuItem4"));

    }

}
