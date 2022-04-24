package com.example.demo.views.admin;

import com.example.demo.Course;
import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Route(value = "add-course", layout = AdminLayout.class)
public class AddCourseView extends VerticalLayout { //todo:

    @Autowired
    private SubmissionRepo submissionRepo;
    @Autowired
    private CourseRepo courseRepo;
    Binder<Course> binder = new Binder<>(Course.class);

    TextField courseName = new TextField("Course Name");
    Button submit = new Button("Submit");
    VerticalLayout verticalLayout = new VerticalLayout();



    public AddCourseView (Submission repo, CourseRepo courseRepo) {
        binder.bind(courseName, Course::getCourseName, Course::setCourseName);

        binder.bindInstanceFields(this);
        binder.setBean(new Course());

        add(new H1("Add Course"),
                new HorizontalLayout(courseName),
                new HorizontalLayout(submit));
        setHeightFull();;
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        submit.addClickListener(event -> save());
        submit.addClickShortcut(Key.ENTER);

    }

    private void save() {
        Course course = binder.getBean();
        courseRepo.save(course);
        UI.getCurrent().navigate("admin-home");
    }

}