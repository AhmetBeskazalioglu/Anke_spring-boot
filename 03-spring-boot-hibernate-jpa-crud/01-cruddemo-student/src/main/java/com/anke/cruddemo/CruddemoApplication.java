package com.anke.cruddemo;

import com.anke.cruddemo.dao.FamilyDAO;
import com.anke.cruddemo.dao.StudentDAO;
import com.anke.cruddemo.entity.LombokFamily;
import com.anke.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, FamilyDAO familyDAO) {
		return runner -> {
			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			createFamily(familyDAO);

			//readStudent(studentDAO);
			//readFamily(familyDAO);

			//queryForStudents(studentDAO);
			//queryForFamilies(familyDAO);
			
			//queryForStudentsByLastName(studentDAO);
			//queryForFamiliesByLastName(familyDAO);

			//updateStudent(studentDAO);
			//updateFamily(familyDAO);

			//deleteStudent(studentDAO);
			//deleteFamily(familyDAO);

			//deleteAllStudents(studentDAO);
			//deleteAllFamilies(familyDAO);
		};
	}

	private void deleteAllFamilies(FamilyDAO familyDAO) {
		System.out.println("Deleted all families");
		int deletedFamilies = familyDAO.deleteAll();
		System.out.println("Deleted families: " + deletedFamilies);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleted all students");
		int deletedStudents = studentDAO.deleteAll();
		System.out.println("Deleted students: " + deletedStudents);
	}

	private void deleteFamily(FamilyDAO familyDAO) {
		familyDAO.delete(2);
		System.out.println("Deleted family");

	}

	private void deleteStudent(StudentDAO studentDAO) {
		studentDAO.delete(2);
		System.out.println("Deleted student");
	}

	private void updateFamily(FamilyDAO familyDAO) {
		familyDAO.update(familyDAO.findById(1));
		System.out.println("Updated family");

	}

	private void updateStudent(StudentDAO studentDAO) {
		studentDAO.update(studentDAO.findById(1));
		System.out.println("Updated student");
	}

	private void queryForFamiliesByLastName(FamilyDAO familyDAO) {
		List<LombokFamily> families = familyDAO.findByLastName("b");
		for (LombokFamily family : families) {
			System.out.println(family);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Beskazalioglu");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForFamilies(FamilyDAO familyDAO) {
		List<LombokFamily> families = familyDAO.findAll();
		for (LombokFamily family : families) {
			System.out.println(family);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readFamily(FamilyDAO familyDAO) {
		// Create a family
		System.out.println("Creating a new family object ...");
		LombokFamily tempFamily = new LombokFamily("anke","beskazalioglu");

		// save the family
		System.out.println("Saving the family ...");
		familyDAO.save(tempFamily);

		// display id of the saved family
		int id = tempFamily.getId();
		System.out.println("Saved family. Generated id: " + id);

		// retrieve the family
		System.out.println("Getting family with id: " + id);
		LombokFamily theFamily = familyDAO.findById(id);

		// display the family
		System.out.println("Get complete: " + theFamily);


	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Anke", "Beskazalioglu", "ab@g.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int id = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		// retrieve the student
		System.out.println("Getting student with id: " + id);
		Student theStudent = studentDAO.findById(id);

		// display the student
		System.out.println("Get complete: " + theStudent);
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
