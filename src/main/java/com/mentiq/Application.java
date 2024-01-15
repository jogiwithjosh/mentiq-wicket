package com.mentiq;

import org.apache.wicket.Page;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;

public class Application extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return com.mentiq.Index.class;
    }

    @Override
    public void init() {
        super.init();
        getResourceSettings().getResourceFinders().add(new WebApplicationPath(getServletContext(), "/"));
    }

}