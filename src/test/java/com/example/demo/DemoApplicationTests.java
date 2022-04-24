package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserRepo repo;
	@Autowired
	SubmissionRepo submissionRepo;

	@Autowired
	CourseRepo courseRepo;

	@BeforeEach
	public void submissionLoader() {
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
		courseRepo.save(dsa);

		Submission google = new Submission("www.google.com", "COP3503", "", "ericSWE", eric);
		Submission khanAcademy = new Submission("www.khanacademy.com", "CEN3031", "Useful for a variety of subjects", "ericSWE", eric);
		Submission youtube = new Submission("www.youtube.com", "COP3503", "Instructional Videos", "zachSWE", zach);
		Submission wikipedia = new Submission("wwww.wikipedia.com", "CEN3031", "Open-Source Encyclopedia", "stoneSWE", stone);
		submissionRepo.save(wikipedia);
		submissionRepo.save(youtube);
		submissionRepo.save(google);
		submissionRepo.save(khanAcademy);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testLinkLoader() throws Exception {
		List<Submission> submissions = (ArrayList<Submission>) submissionRepo.findAll();
		assertTrue(submissions.contains(submissionRepo.findByLink("www.google.com").get(0)));
		assertTrue(submissions.contains(submissionRepo.findByLink("www.khanacademy.com").get(0)));
		assertTrue(submissions.contains(submissionRepo.findByLink("www.youtube.com").get(0)));
		assertTrue(submissions.contains(submissionRepo.findByLink("www.wikipedia.com").get(0)));
	}

	@Test
	void testUserLoader() throws Exception {
		List<User> users = (ArrayList<User>) repo.findAll();
		assertTrue(users.contains(repo.findByUsername("ericSWE").get(0)));
		assertTrue(users.contains(repo.findByUsername("admin").get(0)));
	}

	@Test
	void testCourseLoader() throws Exception {
		List<Course> courses = (ArrayList<Course>) courseRepo.findAll();
		assertTrue(courses.contains(courseRepo.findByCourseName("CEN3031").get(0)));
		assertTrue(courses.contains(courseRepo.findByCourseName("COP3503").get(0)));
	}
}

