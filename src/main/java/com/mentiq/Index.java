package com.mentiq;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class Index extends WebPage {
    public Index() {
        add(new Label("index", "Welcome to Dream House Realty!"));
    }
}