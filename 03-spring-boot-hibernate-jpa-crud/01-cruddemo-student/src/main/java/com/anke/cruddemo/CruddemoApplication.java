package com.anke.cruddemo;

import com.anke.cruddemo.dao.FamilyDAO;
import com.anke.cruddemo.dao.FamilyDAOImpl;
import com.anke.cruddemo.dao.StudentDAO;
import com.anke.cruddemo.entity.LombokFamily;
import com.anke.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, FamilyDAO familyDAO) {
		return runner -> {
			createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			createFamily(familyDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create multiple students
		System.out.println("Creating multiple students");
		Student tempStudent1 = new Student("Ahmet", "Beskazalioglu", "ahm@gma.com");
		Student tempStudent2 = new Student("Nesrin", "Beskazalioglu", "nesa@sa.com");
		Student tempStudent3 = new Student("Kerem", "Beskazalioglu", "dsds@asda.com");
		Student tempStudent4 = new Student("Elif", "Beskazalioglu", "sda@da.com");

		// save the students
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		System.out.println("Saving the students...");

		// display the students by id
		System.out.println("Saved student: " + tempStudent1.getId());
		System.out.println("Saved student: " + tempStudent2.getId());
		System.out.println("Saved student: " + tempStudent3.getId());
		System.out.println("Saved student: " + tempStudent4.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// Create a student
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Anke", "Beskazalioglu", "ankebeskazali@gmail.com");

		// save the student
		studentDAO.save(tempStudent);
		System.out.println("Saving the student...");

		// display the student by id
		System.out.println("Saved student: " + tempStudent.getId());
	}

	private void createFamily(FamilyDAO familyDAO) {
		// Create a family
		System.out.println("Creating a new family");
		LombokFamily tempFamily = new LombokFamily("a","b");

		// save the family
		familyDAO.save(tempFamily);
		System.out.println("Saving the family...");

		// display the family by id
		System.out.println("Saved family: " + tempFamily.getId());
	}
}
