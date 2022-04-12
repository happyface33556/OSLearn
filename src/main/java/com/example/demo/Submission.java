package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Repository
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String link;
    private String courseName;
    private String comments;
    private Boolean approval = false;
    private String studentName;
    private int numLikes;
    private int numDislikes;
    private double userScore; //TODO: Decide how to calculate user score using likes and dislikes

    public Submission() {}

    public Submission(String link) {
        this.link = link;
    }

}

