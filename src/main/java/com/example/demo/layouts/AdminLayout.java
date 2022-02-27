package com.example.demo.layouts;

import com.example.demo.views.admin.AllSubmissionsAdminView;
import com.example.demo.views.admin.PendingView;
import com.example.demo.views.admin.SearchAdminView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class AdminLayout extends AppLayout {

    public AdminLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Welcome to OSLearn!"); //todo: custom message for administrator
        logo.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        addToNavbar(header);

    }

    private void createDrawer() { ////todo: new tabs like MySubmissions, SubmissionSearch, etc.
        RouterLink newSub = new RouterLink("Pending Submissions", PendingView.class); //todo: PendingSubmissions
        RouterLink allSub = new RouterLink("All Submissions", AllSubmissionsAdminView.class); //todo: allSubmissions
        RouterLink search = new RouterLink("Search", SearchAdminView.class); //todo: create search

        addToDrawer(new VerticalLayout(
                newSub,
                allSub,
                search
        ));
    }
}
