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

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        // create a StudentErrorResponse

        StudentErrorResponse error= new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    // add another exception handler... to catch any exception (catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        // create a StudentErrorResponse

        StudentErrorResponse error= new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}