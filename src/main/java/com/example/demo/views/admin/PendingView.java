package com.example.demo.views.admin;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "pending-submissions", layout = AdminLayout.class)
public class PendingView extends VerticalLayout { //todo:
    Grid<Submission> grid = new Grid<>(Submission.class, false);

    Binder<Submission> binder = new Binder<>(Submission.class);

    public PendingView(SubmissionRepo repo) {
        grid.setColumns("courseName", "link", "comments");
        grid.addColumn(
                new NativeButtonRenderer<Submission>("Approve",
                        clickedItem -> {
                    clickedItem.setApproval(Boolean.TRUE);
                        })
        );
        grid.addColumn(
                new NativeButtonRenderer<Submission>("Reject",
                        clickedItem -> {
                    repo.delete(clickedItem);
                        })
        );
    }

    private void reject() {

    }
}