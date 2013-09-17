package com.homenet.bootstrap.loader;


import com.vaadin.server.FileResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;

import java.io.File;

public class RootLayoutFactory {
    private CustomLayout rootLayout;

    protected RootLayoutFactory() {

    }

    public void setCompositionPage(Component page) {
        rootLayout.addComponent(page, "content");
    }

    void setRootlayout(CustomLayout rootLayout) {
        this.rootLayout = rootLayout;
    }

    public void customizeLogo(File url) {
        Image image = new Image("", new FileResource(url));
        rootLayout.addComponent(image, "ui-logo");
    }

}

