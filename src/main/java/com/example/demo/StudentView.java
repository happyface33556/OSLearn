package com.example.demo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("student")
public class StudentView extends VerticalLayout {
    public StudentView() {
        add(new H1("This will be the STUDENT Screen"));
    }
}
