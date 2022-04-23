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
	CommandLineRunner submissionLoader(UserRepo repo, CourseRepo courseRepo, SubmissionRepo submissionRepo) {
		return args -> {
			Course swe = new Course("CEN3031");
			HashSet<Course> s = new HashSet<Course>();
			s.add(swe);
			repo.save(new User((long) 1, "Sanethia", "Thomas", "admin", "password", s, User.Type.TEACHER));

			User eric = new User((long) 2, "Eric", "McGuirk", "ericSWE", "password", s, User.Type.STUDENT);
			User zach = new User((long) 3, "Zachary", "Deptula", "zachSWE", "password", s, User.Type.STUDENT);
			User stone = new User((long) 4, "Stone", "Blumauer", "stoneSWE", "password", s, User.Type.STUDENT);
			repo.save(eric);
			repo.save(zach);
			repo.save(stone);
			Course dsa = new Course("COP3503");

			Submission google = new Submission("www.google.com");
			Submission khanAcademy = new Submission("www.khanacademy.com");
			khanAcademy.setOwner(eric);
			khanAcademy.setComments("Useful for a variety of subjects");
			google.setOwner(eric);
			google.setCourseName("COP3503");
			khanAcademy.setCourseName("CEN3031");
			google.setComments("");
			submissionRepo.save(google);
			submissionRepo.save(khanAcademy);

		};
	}
}
