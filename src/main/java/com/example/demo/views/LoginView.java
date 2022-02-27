package com.example.demo.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Login | OSLearn")
public class LoginView extends Composite<LoginOverlay> { //todo: add actual security
    public LoginView() {
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("OSLearn");
        loginOverlay.setDescription("Expand your learning!");
        loginOverlay.setOpened(true);

        loginOverlay.addLoginListener(event -> {
            if ("user".equals(event.getUsername())) {
                UI.getCurrent().navigate("student-home");
            }
            else if ("admin".equals(event.getUsername())) {
                UI.getCurrent().navigate("admin-home");
            }
            else {
                loginOverlay.setError(true);
            }
        });
    }
}