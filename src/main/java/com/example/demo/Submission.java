package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String link;
    private String courseName;
    private String comments;
    private Boolean approval = false;
    private String studentName;
    private int numLikes = 0;
    private int numDislikes = 0;
    private double userScore = 0; //TODO: Decide how to calculate user score using likes and dislikes

    public Submission(String link) {
        this.link = link;
    }

}

