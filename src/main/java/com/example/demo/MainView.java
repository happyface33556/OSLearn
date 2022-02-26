package com.example.demo;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.core.Ordered;

@Route("")
@PageTitle("Title Page")
public class MainView extends Composite<LoginOverlay> {
    public MainView() {
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("OSLearn");
        loginOverlay.setDescription("Expand your learning!");
        loginOverlay.setOpened(true);

        loginOverlay.addLoginListener(event -> {
            if ("user".equals(event.getUsername())) {
                UI.getCurrent().navigate("student");
            }
            else if ("admin".equals(event.getUsername())) {
                UI.getCurrent().navigate("admin");
            }
            else {
                Notification.show("Wrong Credentials. Please Try Again.");
            }
        });
    }
}
