package com.example.demo.views.student;

import com.example.demo.Course;
import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.StudentLayout;
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

@Route(value = "submission", layout = StudentLayout.class)
public class SubmissionView extends VerticalLayout {

    @Autowired
    private SubmissionRepo submissionRepo;
    @Autowired
    private CourseRepo courseRepo;
    Binder<Submission> binder = new Binder<>(Submission.class);

    TextField linkField = new TextField("Link");
    ComboBox<String> courseBox = new ComboBox<>("Course");
    TextField commentField = new TextField("Comments");
    Button submit = new Button("Submit");
    VerticalLayout verticalLayout = new VerticalLayout();



    public SubmissionView(Submission repo, CourseRepo courseRepo) {
        binder.bind(linkField, Submission::getLink, Submission::setLink);
        binder.bind(commentField, Submission::getComments, Submission::setComments);
        binder.bind(courseBox, Submission::getCourseName, Submission::setCourseName);
        binder.bindInstanceFields(this);
        binder.setBean(new Submission());

        ArrayList<String> course_names = new ArrayList<>();
        for (Course course : courseRepo.findAll()) {
            course_names.add(course.getCourseName());
        }
        courseBox.setItems(course_names);

        add(new H1("Submission"),
                new HorizontalLayout(linkField),
                new HorizontalLayout(courseBox),
                new HorizontalLayout(commentField),
                new HorizontalLayout(submit));
        setHeightFull();;
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        submit.addClickListener(event -> save());
        submit.addClickShortcut(Key.ENTER);

    }

    private void save() {
        Submission submission = binder.getBean();
        submissionRepo.save(submission);
        UI.getCurrent().navigate("my-submissions");
    }

}
