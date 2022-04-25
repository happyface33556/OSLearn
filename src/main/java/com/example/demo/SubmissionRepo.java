package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission, Long> {

    public ArrayList<Submission> findAllByStatus(Submission.Status status);
    public ArrayList<Submission> findByUsername(String username);
    public ArrayList<Submission> findByLink(String link);
    public ArrayList<Submission> findByCourseName(String name);
    public ArrayList<Submission> findByLinkContainsAndStatus(String link, Submission.Status status);
    public ArrayList<Submission> findByCourseNameAndStatus(String name, Submission.Status status);
    public ArrayList<Submission> findByUsernameAndStatus(String username, Submission.Status status);

    public default String getStudentName(Submission submission) {
        return String.format("%s, %s", submission.getOwner().getLname(),
                submission.getOwner().getFname());
    }
}
