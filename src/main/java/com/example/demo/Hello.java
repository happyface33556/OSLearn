package com.example.demo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class Hello extends VerticalLayout {
    public Hello() {
        add(new H1("hello world"));
    }
}
