package com.example.springbootcrud.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.example.springbootcrud.model.Student;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "john", "sb"),
                    new Student(2, "mith", "react"),
                    new Student(3, "afrin", "java")
            )
    );

    public List<Student> getAllStudent() {
        return students;
    }

    public Student getStudentByRollNo(int roll) {

        for(Student s : students){
            if(s.getRollno() == roll){
                return s;
            }
        }

        return new Student(0," "," ");
    }

    public void addStudent(Student std){
        students.add(std);
    }

    public void updateStudent(Student std){

        for(int i=0; i<students.size(); i++){

            if(students.get(i).getRollno() == std.getRollno()){

                students.set(i,std);
                return;
            }
        }
    }

    public String deleteStudent(int r){

        for(int i=0; i<students.size(); i++){

            if(students.get(i).getRollno() == r){

                students.remove(i);
                return "Deleted Successfully";
            }
        }

        return "Student Not Found";
    }
}