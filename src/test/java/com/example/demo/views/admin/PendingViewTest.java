package com.example.demo.views.admin;

import com.example.demo.Submission;
import com.example.demo.SubmissionRepo;
import com.vaadin.flow.component.grid.Grid;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PendingViewTest {

    @Autowired
    SubmissionRepo repo;

    private Submission google;
    private Submission khanAcademy;

    @BeforeEach
    public void setupData() {
        ArrayList<Submission> submissions = new ArrayList<>();
        google = new Submission();
        khanAcademy = new Submission();
        google.setLink("www.google.com");
        google.setStatus(Submission.Status.PENDING);
        khanAcademy.setLink("www.khanacademy.com");
        khanAcademy.setStatus(Submission.Status.PENDING);
        submissions.add(google);
        submissions.add(khanAcademy);
    }

    @Test
    public void PendingViewReject() {
        PendingView view = new PendingView(repo);
        view.reject(repo, google);
        assertEquals(google.getStatus(), Submission.Status.NO);
    }

    @Test
    public void PendingViewApprove() {
        PendingView view = new PendingView(repo);
        view.approve(repo, google);
        assertEquals(google.getStatus(), Submission.Status.YES);
    }
}