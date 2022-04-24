package com.example.demo.views.student;

import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.StudentLayout;
import com.example.demo.views.Search;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Route(value = "student-results", layout = StudentLayout.class)
public class StudentSearchResultView extends VerticalLayout {
    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private CourseRepo courseRepo;

    Grid<Submission> submissionGrid = new Grid<>(Submission.class);
    public StudentSearchResultView(SubmissionRepo repo) {
        Search inquiry = ComponentUtil.getData(UI.getCurrent(), Search.class);
        submissionGrid.setColumns("courseName", "link", "comments");
        if (Objects.equals(inquiry.getParameter(), "Links")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByLinkAndStatus(input, Submission.Status.YES));
        }
        if (Objects.equals(inquiry.getParameter(), "Course Name")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByCourseNameAndStatus(input, Submission.Status.YES));
        }
        if (Objects.equals(inquiry.getParameter(), "Owner")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByUsernameAndStatus(input, Submission.Status.YES));
        }
        add(new H1("Search Results"));
        add(submissionGrid);
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
