package com.example.demo.views.admin;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "all-submissions-admin", layout = AdminLayout.class)
@PageTitle("All Submissions | OSLearn")
public class AllSubmissionsAdminView extends VerticalLayout { //todo:

    Grid<Submission> grid = new Grid<>(Submission.class, false);

    public AllSubmissionsAdminView(SubmissionRepo repo) {
        grid.setColumns("courseName", "link", "comments", "status");
        grid.addColumn(repo::getStudentName).setHeader("Submitter");
        grid.getColumnByKey("status").setHeader("Approved?");
        grid.setItems(repo.findAll());
        add(grid);
    }
}
