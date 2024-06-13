package com.anke.demo.rest;

import com.anke.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        // check the studentId again list size

        if ((studentId >= students.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id is not found - "+studentId);
        }
        return students.get(studentId);
    }
}