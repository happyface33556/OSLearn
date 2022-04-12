package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fname;
    private String lname;

    @OneToMany
    private Set<Course> courseName;

    private Type type;

    enum Type {
        STUDENT,
        TEACHER,
        ADMINISTRATOR
    }
}
