package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Long> {

    ArrayList<Submission> findAllByStatus(Submission.Status status);
}
