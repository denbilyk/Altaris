package com.homenet.demo.ui;


import com.homenet.bootstrap.loader.RootLayoutFactory;
import com.homenet.bootstrap.loader.UIRootLoader;
import com.vaadin.ui.Button;

import java.io.File;


public class CustomBaseLayout implements UIRootLoader {

    @Override
    public void getRootFactory(RootLayoutFactory factory) {
        factory.setCompositionPage(new Button("test"));
        File logo = new File("resources/img/logo.png");
        factory.customizeLogo(logo);
    }

}
