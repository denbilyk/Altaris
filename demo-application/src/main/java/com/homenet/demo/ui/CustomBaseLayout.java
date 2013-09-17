package com.homenet.demo.ui;


import com.homenet.bootstrap.loader.RootLayoutFactory;
import com.vaadin.ui.Button;

import java.io.File;


public class CustomBaseLayout extends RootLayoutFactory {

    public CustomBaseLayout() {
        super();
        setCompositionPage(new Button("test"));
        File logo = new File("resources/img/logo.png");
        customizeLogo(logo);
    }


}
