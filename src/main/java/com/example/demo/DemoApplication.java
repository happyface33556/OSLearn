package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	CommandLineRunner courseLoader(CourseRepo repo) {
		return args -> {
			repo.save(new Course("COT3100"));
			repo.save(new Course("CEN3031"));
		};
	}

	@Bean
	CommandLineRunner submissionLoader(UserRepo repo, CourseRepo courseRepo) {
		return args -> {
			Course swe = new Course("CEN3031");
			HashSet<Course> s = new HashSet<Course>();
			s.add(swe);
			repo.save(new User((long) 1, "Sanethia", "Thomas", s, User.Type.TEACHER));
			repo.save(new User((long) 2, "Eric", "McGuirk", s, User.Type.STUDENT));
			Course dsa = new Course("COP3503");
		};
	}
}
