package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CourseRepo extends CrudRepository<Course, String> {
    ArrayList<Course> findByCourseName(String name);
}
