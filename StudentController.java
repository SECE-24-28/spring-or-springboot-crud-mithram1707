package com.example.springbootcrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.springbootcrud.model.Student;
import com.example.springbootcrud.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService s;

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return s.getAllStudent();
    }

    @GetMapping("/student/{rollno}")
    public Student getByStudentRollNo(@PathVariable int rollno){
        return s.getStudentByRollNo(rollno);
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student std){

        s.addStudent(std);
        return "SUCCESS";
    }

    @PutMapping("/student")
    public String updateStudent(@RequestBody Student std){

        s.updateStudent(std);
        return "Updated Successfully";
    }

    @DeleteMapping("/student/{rollno}")
    public String deleteStudent(@PathVariable int rollno){

        return s.deleteStudent(rollno);
    }
}