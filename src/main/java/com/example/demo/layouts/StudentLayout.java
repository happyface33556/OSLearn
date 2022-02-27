package com.example.demo.layouts;

import com.example.demo.views.LoginView;
import com.example.demo.views.student.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Router;
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

        Button button = new Button("New Submission");
        button.getStyle().set("margin-left", "auto");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, button);

        addToNavbar(header, button);

        button.addClickListener(clickEvent -> {
            UI.getCurrent().navigate("submission");
        });

    }

    private void createDrawer() { //todo: new tabs like MySubmissions, SubmissionSearch, etc.
        RouterLink home = new RouterLink("Home", StudentView.class);
        RouterLink myCourse = new RouterLink("My Courses", MyCoursesView.class);
        RouterLink allSub = new RouterLink("All Submissions", AllSubmissionsStudentView.class);
        RouterLink mySub = new RouterLink("My Submissions", MySubmissionsView.class);
        RouterLink search = new RouterLink("Search", SearchStudentView.class);
        RouterLink logout = new RouterLink("Logout", LoginView.class);

        addToDrawer(new VerticalLayout(
                home,
                myCourse,
                allSub,
                mySub,
                search,
                logout
        ));
    }
}
