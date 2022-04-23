package com.example.demo.layouts;

import com.example.demo.User;
import com.example.demo.views.LoginView;
import com.example.demo.views.admin.*;
import com.example.demo.views.student.StudentView;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class AdminLayout extends AppLayout {

    public AdminLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        User currentUser = ComponentUtil.getData(UI.getCurrent(), User.class);
        H1 logo = new H1("Welcome to OSLearn, " + currentUser.getFname() + "!"); //todo: custom message for administrator
        logo.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");


        Button button = new Button("Add Course", new Icon(VaadinIcon.PAPERPLANE));
        button.setIconAfterText(true);
        button.getStyle().set("margin-left", "auto");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, button);

        addToNavbar(header, button);

        button.addClickListener(clickEvent -> {
            UI.getCurrent().navigate("add-course");

        });
    }

    private void createDrawer() {
        RouterLink home = new RouterLink("Home ", AdminView.class);
        Icon homeIcon = new Icon(VaadinIcon.HOME);
        home.add(homeIcon);

        RouterLink courses = new RouterLink("Courses ", CourseView.class);

        RouterLink newSub = new RouterLink("Pending Submissions ", PendingView.class); //todo: PendingSubmissions
        Icon newIcon = new Icon(VaadinIcon.FOLDER_ADD);
        newSub.add(newIcon);

        RouterLink allSub = new RouterLink("All Submissions ", AllSubmissionsAdminView.class); //todo: allSubmissions
        Icon allIcon = new Icon(VaadinIcon.ARCHIVES);
        allSub.add(allIcon);

        RouterLink search = new RouterLink("Search ", SearchAdminView.class); //todo: gfcreate search
        Icon searchIcon = new Icon(VaadinIcon.SEARCH);
        search.add(searchIcon);

        RouterLink logout = new RouterLink("Logout ", LoginView.class);
        Icon logoutIcon = new Icon(VaadinIcon.SIGN_OUT);
        logout.add(logoutIcon);

        addToDrawer(new VerticalLayout(
                home,
                courses,
                newSub,
                allSub,
                search,
                logout
        ));
    }
}
