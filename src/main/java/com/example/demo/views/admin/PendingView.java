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
public class PendingView extends VerticalLayout { //todo:
    Grid<Submission> grid = new Grid<>(Submission.class, false);

    Binder<Submission> binder = new Binder<>(Submission.class);

    public PendingView(SubmissionRepo repo) {
        grid.setColumns("courseName", "link", "comments");

        grid.addColumn(new ComponentRenderer<>(submission -> {
            Button approve = new Button("Approve", event -> {
                submission.setApproval(Boolean.TRUE);
                grid.getDataProvider().refreshItem(submission);
            });
            approve.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            Button reject = new Button("Reject", event -> {
                ListDataProvider<Submission> dataProvider =
                        (ListDataProvider<Submission>) grid.getDataProvider();
                repo.delete(submission);
                dataProvider.getItems().remove(submission);
                dataProvider.refreshAll();;
            });
            reject.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

            HorizontalLayout buttons = new HorizontalLayout(approve, reject);
            return buttons;
        })).setHeader("Approve/Reject");

        grid.setItems(repo.findAll());

        add(grid);
    }

    private void reject() {

    }
}