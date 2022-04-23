package com.example.demo.views;

import com.example.demo.User;
import com.example.demo.UserRepo;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Route(value = "")
@PageTitle("Login | OSLearn")
public class LoginView extends Composite<LoginOverlay> { //todo: add actual security
    @Autowired
    private UserRepo userRepo;

    public LoginView() {
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setTitle("OSLearn");
        loginOverlay.setDescription("Expand your learning!");
        loginOverlay.setOpened(true);

        loginOverlay.addLoginListener(event -> {
            ArrayList<User> users = (ArrayList<User>) userRepo.findAll();
            for (int i = 0; i < users.size(); i++) {
                if (Objects.equals(users.get(i).getUsername(), event.getUsername()) && Objects.equals(users.get(i).getPassword(), event.getPassword())) {
                    ComponentUtil.setData(UI.getCurrent(), User.class, users.get(i));
                    UI.getCurrent().navigate("student-home");
                }
            }
            /*if ("ericSWE".equals(event.getUsername())) {
                ComponentUtil.setData(UI.getCurrent(), User.class, eric);
                UI.getCurrent().navigate("student-home");
            }*/
            /*else*/ if ("admin".equals(event.getUsername())) {
                UI.getCurrent().navigate("admin-home");
            }
            else {
                loginOverlay.setError(true);
            }
        });
    }
}