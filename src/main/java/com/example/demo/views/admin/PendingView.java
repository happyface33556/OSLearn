package com.example.demo.views.admin;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.AdminLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "pending-submissions", layout = AdminLayout.class)
public class PendingView extends VerticalLayout {
    Grid<Submission> grid = new Grid<>(Submission.class, false);

    public PendingView(SubmissionRepo repo) {
        grid.setColumns("courseName", "link", "comments", "status");

        grid.addColumn(new ComponentRenderer<>(submission -> {
            Button approve = new Button("Approve", event -> {
                ListDataProvider<Submission> dataProvider =
                        (ListDataProvider<Submission>) grid.getDataProvider();
                submission.setStatus(Submission.Status.YES);
                repo.save(submission);
                dataProvider.getItems().remove(submission);
                dataProvider.refreshAll();
            });
            approve.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            Button reject = new Button("Reject", event -> {
                ListDataProvider<Submission> dataProvider =
                        (ListDataProvider<Submission>) grid.getDataProvider();
                reject(repo, submission);
                dataProvider.getItems().remove(submission);
                dataProvider.refreshAll();;
            });
            reject.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

            HorizontalLayout buttons = new HorizontalLayout(approve, reject);
            return buttons;
        })).setHeader("Approve?");

        grid.setItems(repo.findAllByStatus(Submission.Status.PENDING));

        add(grid);
    }

    protected void reject(SubmissionRepo repo, Submission submission) {
        submission.setStatus(Submission.Status.NO);
        repo.save(submission);
    }
}