package com.example.demo.views.admin;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.User;
import com.example.demo.layouts.AdminLayout;
import com.example.demo.views.Search;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Objects;

@Route(value = "admin-results", layout = AdminLayout.class)
public class AdminSearchResultView extends VerticalLayout {
    @Autowired
    private SubmissionRepo submissionRepo;

    Grid<Submission> submissionGrid = new Grid<>(Submission.class);
    public AdminSearchResultView(SubmissionRepo repo) {
        Search inquiry = ComponentUtil.getData(UI.getCurrent(), Search.class);
        submissionGrid.setColumns("courseName", "link", "comments");
        submissionGrid.addColumn(this::checkStatus).setHeader("Status");
        if (Objects.equals(inquiry.getParameter(), "Links")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByLinkContains(input));
            if (repo.findByLinkContains(input).isEmpty()) {
                add(new H1("No Results Found"));
            }
            else {
                add(new H1("Search Results"));
                add(submissionGrid);
            }
        }
        if (Objects.equals(inquiry.getParameter(), "Course Name")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByCourseName(input));
            if (repo.findByCourseName(input).isEmpty()) {
                add(new H1("No Results Found"));
            }
            else {
                add(new H1("Search Results"));
                add(submissionGrid);
            }
        }
        if (Objects.equals(inquiry.getParameter(), "Owner")) {
            String input = inquiry.getInput();
            submissionGrid.setItems(repo.findByUsername(input));
            if (repo.findByUsername(input).isEmpty()) {
                add(new H1("No Results Found"));
            }
            else {
                add(new H1("Search Results"));
                add(submissionGrid);
            }
        }
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
    private String checkStatus(Submission submission) {
        HashMap<Submission.Status, String> map = new HashMap<>();
        map.put(Submission.Status.NO, "Rejected");
        map.put(Submission.Status.PENDING, "Pending");
        map.put(Submission.Status.YES, "Approved");

        return map.get(submission.getStatus());
    }
}
