package com.example.demo.views.student;

import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "student-home", layout = StudentLayout.class) //todo: create a home page after login
public class StudentView extends VerticalLayout {
    public StudentView() {
        Image logo = new Image("images/image10.jpeg", "logo");
        logo.setWidth(400, Unit.PIXELS);
        add(new HorizontalLayout(logo));
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
