package com.example.demo.layouts;

import com.example.demo.views.student.AllSubmissionsViewStudent;
import com.example.demo.views.student.SubmissionView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class StudentLayout extends AppLayout {

    public StudentLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Welcome to OSLearn!"); //todo: custom message for user
        logo.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        addToNavbar(header);

    }

    private void createDrawer() { //todo: new tabs like MySubmissions, SubmissionSearch, etc.
        RouterLink newSub = new RouterLink("New Submission", SubmissionView.class);
        RouterLink allSub = new RouterLink("All Submissions", AllSubmissionsViewStudent.class); //todo: allSubmissions

        addToDrawer(new VerticalLayout(
                newSub,
                allSub
        ));
    }
}
