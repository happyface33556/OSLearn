package com.example.demo.views.student;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Route(value = "my-courses", layout = StudentLayout.class)
public class MyCoursesView extends VerticalLayout {
    @Autowired
    private SubmissionRepo repo;

    public MyCoursesView(SubmissionRepo repo) {
        ArrayList<Submission> submissions = repo.findAllByStatus(Submission.Status.YES);
        ArrayList<String> courseNames = new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++) {
            if (!courseNames.contains(submissions.get(i).getCourseName())) {
                courseNames.add(submissions.get(i).getCourseName());
            }
        }
        for (int i = 0; i < courseNames.size(); i++) {
            Grid<Submission> submissionGrid = new Grid<>(Submission.class);
            submissionGrid.setColumns("courseName", "link", "comments");
            submissionGrid.setItems(repo.findByCourseNameAndStatus(courseNames.get(i), Submission.Status.YES));
            add(new H1(courseNames.get(i)));
            add(submissionGrid);
        }
        if (submissions.size() == 0) {
            add(new H1("No Submissions Available!"));
        }
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

}
