package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Long> {

    public ArrayList<Submission> findAllByStatus(Submission.Status status);

    public default String getStudentName(Submission submission) {
        return String.format("%s, %s", submission.getOwner().getLname(),
                submission.getOwner().getFname());
    }
}
