package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private static final long serialVersionUID = 1L;

    private String link;
    private String courseName;
    private String comments;
    private String username;
    private Status status = Status.PENDING;

    @OneToOne
    private User owner;


    private int numLikes = 0;
    private int numDislikes = 0;
    private double userScore = 0; //TODO: Decide how to calculate user score using likes and dislikes

    public enum Status {
        YES,
        PENDING,
        NO
    }
    public Submission(String link, String courseName, String comments, String username, User owner) {
        this.link = link;
        this.courseName = courseName;
        this.comments = comments;
        this.username = username;
    }
    public String getCourseName() {
        return this.courseName;
    }

}

