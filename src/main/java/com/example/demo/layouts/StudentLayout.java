package com.example.demo.layouts;

import com.example.demo.views.student.AllSubmissionsStudentView;
import com.example.demo.views.student.MySubmissionsView;
import com.example.demo.views.student.SearchStudentView;
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
        RouterLink allSub = new RouterLink("All Submissions", AllSubmissionsStudentView.class); //todo: create all submissions
        RouterLink mySub = new RouterLink("My Submissions", MySubmissionsView.class); //todo: create my submissions
        RouterLink search = new RouterLink("Search", SearchStudentView.class); //todo: create submission search

        addToDrawer(new VerticalLayout(
                newSub,
                allSub,
                mySub,
                search
        ));
    }
}
