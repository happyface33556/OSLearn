package com.example.demo.views.admin;

import com.example.demo.CourseRepo;
import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

@Route(value = "all-submissions-admin", layout = AdminLayout.class)
public class AllSubmissionsAdminView extends VerticalLayout {
    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private CourseRepo courseRepo;

    Grid<Submission> submissionGrid = new Grid<>(Submission.class);
    public AllSubmissionsAdminView(SubmissionRepo repo) {
        submissionGrid.setColumns("courseName", "link", "comments", "username");
        submissionGrid.addColumn(this::checkStatus).setHeader("Status");
        submissionGrid.setItems(repo.findAll());
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
