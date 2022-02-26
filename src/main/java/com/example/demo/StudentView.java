package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;

@Route("student")
public class StudentView extends AppLayout {
    public StudentView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Hello Student!");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tab newSub = new Tab("New Submission");
        Tab allSub = new Tab("All Submissions");
        addToDrawer(newSub, allSub);
        addToNavbar(toggle, title);
    }
}
