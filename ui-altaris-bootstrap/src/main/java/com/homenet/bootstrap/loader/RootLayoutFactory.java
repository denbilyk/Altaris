package com.homenet.bootstrap.loader;


import com.vaadin.server.StreamResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.cssinject.CSSInject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class RootLayoutFactory {
    private CustomLayout rootLayout;
    private CSSInject cssInject;
    private static final Logger log = LoggerFactory.getLogger(RootLayoutFactory.class);

    protected RootLayoutFactory(CustomLayout customLayout, CSSInject cssInject) {
        this.rootLayout = customLayout;
        this.cssInject = cssInject;
    }

    public void addCSSSource(InputStream is) {
        String cssSource = "";
        try {
            byte[] s = IOUtils.toByteArray(is);
            cssSource = new String(s, Charset.forName("UTF-8"));
            IOUtils.closeQuietly(is);
        } catch (IOException e) {
            log.debug("CSS Inject can not be finished. Use UTF-8 encoding.");
            IOUtils.closeQuietly(is);
        }
        cssInject.setStyles(cssSource);
    }

    public void setCompositionPage(Component page) {
        rootLayout.addComponent(page, "content");
    }

    public void customizeLogo(final InputStream url) {
        Image image = new Image(null, new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                return url;
            }
        }, "logo"));
        rootLayout.addComponent(image, "ui-logo");
    }

    public void customizeTopMenuCol2(Component component) {
        rootLayout.addComponent(component, "col2");
    }

    public void customizeTopMenuCol3(Component component) {
        rootLayout.addComponent(component, "col3");
    }

    public void customizeTopMenuCol4(Component component) {
        rootLayout.addComponent(component, "col4");
    }

}

