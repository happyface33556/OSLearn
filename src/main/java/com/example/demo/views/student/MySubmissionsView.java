package com.example.demo.views.student;

import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.User;
import com.example.demo.layouts.StudentLayout;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Route(value = "my-submissions", layout = StudentLayout.class)
public class MySubmissionsView extends VerticalLayout { //todo:

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private CourseRepo courseRepo;

    Grid<Submission> submissionGrid = new Grid<>(Submission.class);
    public MySubmissionsView(SubmissionRepo repo) {
        submissionGrid.setColumns("courseName", "link", "comments");
        submissionGrid.addColumn(this::checkStatus).setHeader("Status");
        submissionGrid.setItems(repo.findByUsername(ComponentUtil.getData(UI.getCurrent(), User.class).getUsername()));
        add(submissionGrid);

    }

    private String checkStatus(Submission submission) {
        HashMap<Submission.Status, String> map = new HashMap<>();
        map.put(Submission.Status.NO, "Rejected");
        map.put(Submission.Status.PENDING, "Pending");
        map.put(Submission.Status.YES, "Approved");

        return map.get(submission.getStatus());
    }
}