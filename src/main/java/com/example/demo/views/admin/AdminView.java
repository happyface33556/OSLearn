package com.example.demo.views.admin;

import com.example.demo.layouts.AdminLayout;
import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;

@Route(value = "admin-home", layout = AdminLayout.class)
public class AdminView extends VerticalLayout {
    public AdminView() {
        Image logo = new Image("images/image10.jpeg", "logo");
        logo.setWidth(400, Unit.PIXELS);
        add(new HorizontalLayout(logo));
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
