package com.anke.OneToOne;

import com.anke.OneToOne.dao.AppDAO;
import com.anke.OneToOne.entity.Course;
import com.anke.OneToOne.entity.Instructor;
import com.anke.OneToOne.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInstructor(appDAO);

            // findInstructor(appDAO);

            // deleteInstructor(appDAO);

            // findInstructorDetail(appDAO);

            // deleteInstructorDetail(appDAO);

            // createInstructorWithCourses(appDAO);

            findInstructorWithCourses(appDAO);
        };
    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        //System.out.println("tempInstructor: " + tempInstructor);
        //System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
        //System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

            // create the instructor
            Instructor tempInstructor =
                    new Instructor("Anke", "Beskazalioglu", "a@a.com");

            // create the instructor detail
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail(
                            "http://www.ankesite.com/youtube",
                            "Coding");

            // create some courses
            Course tempCourse1 = new Course("Chess - The Ultimate Guide");

            Course tempCourse2 = new Course("Atari 2600 - Game Development");

            // add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // save the instructor
            //
            // NOTE: this will ALSO save the details object
            // because of CascadeType.ALL
            //
            System.out.println("Saving instructor: " + tempInstructor);
            System.out.println("Saving courses: " + tempInstructor.getCourses());
            appDAO.save(tempInstructor);

            System.out.println("Done!");


    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Deleting instructor detail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);

        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {

        // get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor
        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Ahmet", "Beskazalioglu", "ahmet@ahmet.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.ahmetbeskazalioglu.com/youtube",
						"Anke!!!");
		*/

        // create the instructor
        Instructor tempInstructor =
                new Instructor("Kerem", "Bekazalioglu", "kerem@kerem.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.kerembeskazalioglu.com/youtube",
                        "Football");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        //
        // NOTE: this will ALSO save the details object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}
