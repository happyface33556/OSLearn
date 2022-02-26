package com.example.demo;

import com.example.demo.Submission;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Vector;

@Route("userSubmission")
public class SubmissionView extends VerticalLayout {

    private Submission repo;
    TextField linkField = new TextField("Link");
    Button submitButton = new Button("Add");
    TextArea textArea = new TextArea("Comment");
    VerticalLayout submissionList = new VerticalLayout();

    public SubmissionView(Submission repo) {
        this.repo = repo;
        List<String> courseNames = new Vector<String>();
        courseNames.add("COP1000");
        courseNames.add("COP2000");
        courseNames.add("COP3000");
        ComboBox<String> courseBox = new ComboBox<>("Courses", courseNames);
        add(new H1("Submission"),
            new HorizontalLayout(linkField),
            new HorizontalLayout(courseBox),
            new HorizontalLayout(textArea),
            submissionList);
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
}
