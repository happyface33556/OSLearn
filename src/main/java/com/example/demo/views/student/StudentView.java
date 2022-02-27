package com.example.demo.views.student;

import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "student", layout = StudentLayout.class)
public class StudentView extends VerticalLayout {


/*
public class StudentView extends AppLayout {

    public StudentView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Hello Student!"); //todo: add customized welcome message to specific usernames
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = getTabs();

        addToNavbar(toggle, title);
        addToDrawer(tabs);
    }

    private Tabs getTabs() {
        Tabs tabs = new Tabs();
        tabs.add(
                createTab("New Submission"),
                createTab("All Submissions") //todo: new tabs like MySubmissions, SubmissionSearch, etc.
        );
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private Tab createTab(String viewName){
        RouterLink link = new RouterLink();
        link.add(new Span(viewName));

        link.setRoute(SubmissionView.class);

        link.setTabIndex(-1);
        return new Tab(link);
    }
/*
    Tab newSub = new Tab("New Submission"); //todo: new tabs like MySubmissions, SubmissionSearch, etc.
    Tab allSub = new Tab("All submissions");
    VerticalLayout content;
    public StudentView() {

        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Hello Student!"); //todo: add customized welcome message to specific usernames
        title.getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        //Tab newSub = new Tab("New Submission");
        //Tab allSub = new Tab("ALl submissions");

        Tabs tabs = new Tabs(newSub, allSub);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        //addToDrawer(newSub, allSub);
        addToNavbar(toggle, title);

        tabs.addSelectedChangeListener(event ->
                setContent(event.getSelectedTab())
        );

        content = new VerticalLayout();
        content.setSpacing(false);
        setContent(tabs.getSelectedTab());

        addToDrawer(tabs, content);
    }



    private void setContent(Tab tab)
    {
        content.removeAll();
        if (tab.equals(newSub))
        {
            UI.getCurrent().navigate("userSubmission");
        }
    }


 */
}
