package com.example.demo.views.admin;

import com.example.demo.layouts.AdminLayout;
import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;

@Route(value = "admin-home", layout = AdminLayout.class) //todo: create an admin home page after login
public class AdminView extends AppLayout {

}
