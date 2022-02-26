package com.example.demo;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;

@Route("admin")
public class AdminView extends AppLayout {
    public AdminView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Hello Administrator!");
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tab pendingSubs = new Tab("Pending Submissions");
        Tab allSubs = new Tab("All Submissions");

        addToDrawer(pendingSubs, allSubs);
        addToNavbar(toggle, title);
    }
}
