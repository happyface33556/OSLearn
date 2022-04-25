package com.example.demo.views.admin;

import com.example.demo.Course;
import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import com.vaadin.flow.component.grid.Grid;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "courses", layout = AdminLayout.class)
public class CourseView extends VerticalLayout {

    public CourseView(SubmissionRepo repo) {
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
            add(new H1("No Submissions Approved, Check Pending Submissions!"));
        }
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

}
