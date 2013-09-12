package com.homenet.bootstrap.loader;


import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

public class RootLayoutFactory {
    private static CustomLayout layout;

    public static LayoutBuilder getBuilder() {
        return new LayoutBuilder();
    }
    public static class LayoutBuilder {
      private static LayoutBuilder builder;
        public static LayoutBuilder customizeLogo( ){
           return builder;
        }

    }

    public static Layout build(){
        try {
            UI ui = UI.getCurrent();
            if (ui != null && ui instanceof BaseBootstrapUI) {
                BaseBootstrapUI uib = (BaseBootstrapUI) ui;
                layout = uib.getBaseLayout();
            }
        } catch (Exception e) {

        }
        return layout;
    }
}

