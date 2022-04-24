package com.example.demo.views.admin;

import com.example.demo.Course;
import com.example.demo.CourseRepo;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import com.vaadin.flow.component.grid.Grid;


@Route(value = "courses", layout = AdminLayout.class)
public class CourseView extends VerticalLayout { //todo:

    Grid<Course> grid = new Grid<>(Course.class, false);

    public CourseView(CourseRepo repo) {
        grid.addColumn(repo::getCourse).setHeader("Course Name");

        add(grid);
    }



}
