package com.example.demo;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fname;
    private String lname;
    private String username;
    private String password;

    // TODO: Use an Iterable<Course> instead
    @ManyToMany
    private Set<Course> courseName;

    private Type type;

    enum Type {
        STUDENT,
        TEACHER,
        ADMINISTRATOR
    }
}
