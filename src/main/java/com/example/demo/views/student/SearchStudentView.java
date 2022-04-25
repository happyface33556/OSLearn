package com.example.demo.views.student;

import com.example.demo.SubmissionRepo;
import com.example.demo.layouts.StudentLayout;
import com.example.demo.views.Search;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Route(value = "student-search", layout = StudentLayout.class)
public class SearchStudentView extends VerticalLayout {
    @Autowired
    private SubmissionRepo submissionRepo;

    ComboBox<String> searchParam = new ComboBox<>("Search By");
    ArrayList<String> searchOptions = new ArrayList<String>();
    TextField input = new TextField();
    Button submit = new Button("Submit");

    public SearchStudentView() {
        searchOptions.add("Links");
        searchOptions.add("Course Name");
        searchOptions.add("Owner");
        searchParam.setItems(searchOptions);

        add(new H1("Search"),
                new HorizontalLayout(searchParam),
                new HorizontalLayout(input),
                new HorizontalLayout(submit));
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        submit.addClickListener(event -> displaySearchResults());
        submit.addClickShortcut(Key.ENTER);
    }

    private void displaySearchResults() {
        Search inquiry = new Search(searchParam.getValue(), input.getValue());
        ComponentUtil.setData(UI.getCurrent(), Search.class, inquiry);
        UI.getCurrent().navigate("student-results");
    }
}
