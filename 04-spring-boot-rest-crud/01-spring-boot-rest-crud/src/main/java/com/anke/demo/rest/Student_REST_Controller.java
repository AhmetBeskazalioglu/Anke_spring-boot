package com.anke.demo.rest;

import com.anke.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Student_REST_Controller {

    private List<Student> students;

    @PostConstruct
    public void loadData(){

        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Mario", "Rossi"));
        students.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ... keep it simple for now
        return students.get(studentId);
    }
}